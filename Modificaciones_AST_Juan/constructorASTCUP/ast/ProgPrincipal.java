package ast;

public class ProgPrincipal {
    ASTNode nodeRoot;
    public ProgPrincipal(ASTNode nodeRoot){
        this.nodeRoot = nodeRoot;
    }

    public String generateCode(){
        StringBuilder str = new StringBuilder();
        str.append(codeStart());

        str.append(codeReserveStack());
        str.append(codeFreeStack());
        str.append(codeCopyN());
        //str.append(codeReserveHeap());

        str.append(codeInit());

        str.append(nodeRoot.generateDecFun());

        str.append(codeEnd());
        return str.toString();
    }



    public String codeStart(){
        StringBuilder str = new StringBuilder();

        str.append("(module\n");
        str.append("(type $_sig_i32ri32 (func (param i32) (result i32)))\n");
        str.append("(type $_sig_i32 (func (param i32)))\n");
        str.append("(type $_sig_ri32 (func (result i32)))\n");
        str.append("(type $_sig_i32i32i32 (func (param i32 i32 i32)))");
        str.append("(type $_sig_void (func ))\n");
        str.append("(import \"runtime\" \"exceptionHandler\" (func $exception (type $_sig_i32)))\n");
        str.append("(import \"runtime\" \"print\" (func $print (type $_sig_i32)))\n");
        str.append("(import \"runtime\" \"read\" (func $read (type $_sig_ri32)))\n");
        str.append("(memory 400)\n");
        str.append("(global $SP (mut i32) (i32.const 0)) ;; start of stack\n");
        str.append("(global $MP (mut i32) (i32.const 0)) ;; mark pointer\n");
        str.append("(global $NP (mut i32) (i32.const 131071996)) ;; heap 2000*64*1024-4\n");
        str.append("(start $init)\n");

        return str.toString();
    }

    public String codeInit(){
        StringBuilder str = new StringBuilder();

        str.append("(func $init (type $_sig_void)\n");

        //reservar memoria para las variables globales (que serán locales de esta función):

        str.append("(local $localsStart i32) \n");
        str.append("(local $temp i32) \n");

        int memGlobals = nodeRoot.maxMem(); //tamaño de las variables globales que se delcaren (en principio sólo habrá eso)
        int mem = memGlobals + 8; //+8 para guardar MP y SP

        //Reservamos la memoria necesaria:
        str.append("i32.const " + mem + " \n");
        str.append("call $reserveStack \n");

        //Establecemos el nuevo marco de memoria (SP, MP, etc.)
        str.append("set_local $temp \n");
        str.append("get_global $MP \n");
        str.append("get_local $temp \n"); 
        str.append("i32.store \n");
        str.append("get_global $MP \n");
        str.append("get_global $SP \n");
        str.append("i32.store offset=4 \n");
        str.append("get_global $MP \n");
        str.append("i32.const 8 \n");
        str.append("i32.add \n");
        str.append("set_local $localsStart \n");
        
        //instrucciones del cuerpo (por si hay alguna asignación inicial a alguna variable global):
        str.append(nodeRoot.generateCode());

        //Llamamos a la función main, que obligatoriamente hemos tenido que definir en nuestro programa.
        //main ha de ser de tipo void (no devuelve nada) y sin parámetros (no devuelve nada)
        
        /*
         * Descomentar cuando este listo
         */
        //str.append("call $main\n");

        str.append("call $freeStack\n");
        str.append(")\n");
        str.append("\n");

        return str.toString();
    }

    public String codeEnd(){
        StringBuilder str = new StringBuilder();
        str.append("(export \"memory\" (memory 0))\n"); //pa debug
        str.append(")\n");
        return str.toString();
    }

    public String codeReserveStack(){
        StringBuilder str = new StringBuilder();

        str.append("(func $reserveStack (param $size i32)\n");
        str.append("(result i32)\n");
        str.append("get_global $MP\n");
        str.append("get_global $SP\n");
        str.append("set_global $MP\n");
        str.append("get_global $SP\n");
        str.append("get_local $size\n");
        str.append("i32.add\n");
        str.append("set_global $SP\n");
        str.append("get_global $SP\n");
        str.append("get_global $NP\n");
        str.append("i32.gt_u\n");
        str.append("if\n");
        str.append("i32.const 3\n");
        str.append("call $exception\n");
        str.append("end\n");
        str.append(")\n");
        str.append("\n");

        return str.toString();
    }

    public String codeFreeStack(){
        StringBuilder str = new StringBuilder();

        str.append("(func $freeStack (type $_sig_void)\n");
        str.append("get_global $MP\n");
        str.append("i32.load\n");
        str.append("i32.load offset=4\n");
        str.append("set_global $SP\n");
        str.append("get_global $MP\n");
        str.append("i32.load\n");
        str.append("set_global $MP\n");
        str.append(")\n");
        str.append("\n");

        return str.toString();
    }


    public String codeCopyN(){
        StringBuilder str = new StringBuilder();

        str.append("(func $copyn (type $_sig_i32i32i32) ;; copy $n i32 slots from $src to $dest\n");
        str.append("(param $src i32)\n");
        str.append("(param $dest i32)\n");
        str.append("(param $n i32)\n");
        str.append("get_local $n\n");
        str.append("i32.const 4\n");
        str.append("i32.div_s\n");
        str.append("set_local $n\n");
        str.append("block\n");
        str.append("loop\n");
        str.append("get_local $n\n");
        str.append("i32.eqz\n");
        str.append("br_if 1\n");
        str.append("get_local $n\n");
        str.append("i32.const 1\n");
        str.append("i32.sub\n");
        str.append("set_local $n\n");
        str.append("get_local $dest\n");
        str.append("get_local $src\n");
        str.append("i32.load\n");
        str.append("i32.store\n");
        str.append("get_local $dest\n");
        str.append("i32.const 4\n");
        str.append("i32.add\n");
        str.append("set_local $dest\n");
        str.append("get_local $src\n");
        str.append("i32.const 4\n");
        str.append("i32.add\n");
        str.append("set_local $src\n");
        str.append("br 0\n");
        str.append("end\n");
        str.append("end\n");
        str.append(")\n");
        str.append("\n");

        return str.toString();
    }

    public String codeReserveHeap(){
        StringBuilder str = new StringBuilder();

        str.append("(func $reserveHeap (param $size i32)\n");
        //str.append("(result i32)\n");
        //Hacemos $NP = $NP-size:
        str.append("get_global $NP\n");
        str.append("get_local $size\n");
        str.append("i32.sub\n");
        str.append("set_global $NP\n");
        //str.append("get_global $NP\n");
        //Comprobamos ahora si SP Y NP se cruzan:
        str.append("get_global $SP\n");
        str.append("get_global $NP\n");
        str.append("i32.gt_u\n");
        str.append("if\n");
        str.append("i32.const 3\n");
        str.append("call $exception\n");
        str.append("end\n");
        str.append(")\n");
        str.append("\n");

        return str.toString();
    }
}




   
   
   
   
     
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
     
   








