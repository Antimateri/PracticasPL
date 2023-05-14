(module
(type $_sig_i32ri32 (func (param i32) (result i32)))
(type $_sig_i32 (func (param i32)))
(type $_sig_ri32 (func (result i32)))
(type $_sig_i32i32i32 (func (param i32 i32 i32)))(type $_sig_void (func ))
(import "runtime" "exceptionHandler" (func $exception (type $_sig_i32)))
(import "runtime" "print" (func $print (type $_sig_i32)))
(import "runtime" "read" (func $read (type $_sig_ri32)))
(memory 10000)
(global $SP (mut i32) (i32.const 0)) ;; start of stack
(global $MP (mut i32) (i32.const 0)) ;; mark pointer
(global $NP (mut i32) (i32.const 131071996)) ;; heap 2000*64*1024-4
(start $init)
(func $reserveStack (param $size i32)
(result i32)
get_global $MP
get_global $SP
set_global $MP
get_global $SP
get_local $size
i32.add
set_global $SP
get_global $SP
get_global $NP
i32.gt_u
if
i32.const 3
call $exception
end
)

(func $freeStack (type $_sig_void)
get_global $MP
i32.load
i32.load offset=4
set_global $SP
get_global $MP
i32.load
set_global $MP
)

(func $copyn (type $_sig_i32i32i32) ;; copy $n i32 slots from $src to $dest
(param $src i32)
(param $dest i32)
(param $n i32)
get_local $n
i32.const 4
i32.div_s
set_local $n
block
loop
get_local $n
i32.eqz
br_if 1
get_local $n
i32.const 1
i32.sub
set_local $n
get_local $dest
get_local $src
i32.load
i32.store
get_local $dest
i32.const 4
i32.add
set_local $dest
get_local $src
i32.const 4
i32.add
set_local $src
br 0
end
end
)

(func $reserveHeap (param $size i32)
get_global $NP
get_local $size
i32.sub
set_global $NP
get_global $SP
get_global $NP
i32.gt_u
if
i32.const 3
call $exception
end
)

(func $pot (param $base i32) (param $exponent i32) (result i32)
(local $result i32)
(local $i i32)
(local.set $i (i32.const 0))
(i32.const 1)
(local.set $result)
(block
(loop
(br_if 1 (i32.eq (local.get $exponent) (i32.const 0)))
(local.set $result (i32.mul (local.get $result) (local.get $base)))
(i32.const 1)
(local.set $exponent (i32.sub (local.get $exponent) (i32.const 1)))
(i32.add (local.get $i) (i32.const 1))
(br 0)
)
)
(local.get $result)
)


(func $init (type $_sig_void)
(local $localsStart i32) 
(local $temp i32) 
i32.const 76 
call $reserveStack 
set_local $temp 
get_global $MP 
get_local $temp 
i32.store 
get_global $MP 
get_global $SP 
i32.store offset=4 
get_global $MP 
i32.const 8 
i32.add 
set_local $localsStart 
i32.const 0
i32.const 0
i32.const 8 
i32.add
i32.add
i32.const 1
i32.store
i32.const 4
i32.const 0
i32.const 8 
i32.add
i32.add
i32.const 2
i32.store
i32.const 8
i32.const 0
i32.const 8 
i32.add
i32.add
i32.const 3
i32.store
i32.const 0
i32.const 0
i32.const 8 
i32.add
i32.add
get_local $localsStart
i32.const 24
i32.add
i32.const 4
call $copyn
i32.const 4
i32.const 0
i32.const 8 
i32.add
i32.add
get_local $localsStart
i32.const 28
i32.add
i32.const 4
call $copyn
i32.const 8
i32.const 0
i32.const 8 
i32.add
i32.add
get_local $localsStart
i32.const 32
i32.add
i32.const 4
call $copyn
i32.const 24
get_local $localsStart
i32.add
get_global $SP
i32.const 8
i32.add
i32.const 12
call $copyn
i32.const 24
get_local $localsStart
i32.add
call $funcion1
i32.const 12
i32.const 0
i32.const 8 
i32.add
i32.add
i32.const 12
call $copyn
i32.const 12
i32.const 0
i32.const 8 
i32.add
i32.add
i32.const 0
i32.add

i32.load

call $print
i32.const 12
i32.const 0
i32.const 8 
i32.add
i32.add
i32.const 4
i32.add

i32.load

call $print
i32.const 12
i32.const 0
i32.const 8 
i32.add
i32.add
i32.const 8
i32.add

i32.load

call $print
i32.const 36
i32.const 0
i32.const 8 
i32.add
i32.add
get_local $localsStart
i32.const 3
i32.store offset=0
i32.const 0
get_local $localsStart
i32.add
get_global $SP
i32.const 8
i32.add
i32.const 4
call $copyn
i32.const 0
get_local $localsStart
i32.add
call $funcion2
i32.load

i32.const 5

i32.add
i32.store 
i32.const 36
i32.const 0
i32.const 8 
i32.add
i32.add

i32.load

call $print
call $freeStack
)

(func $funcion1 (type $_sig_i32ri32)
(param $returnDir i32) 
(result i32) 
(local $localsStart i32) 
(local $temp i32) 
i32.const 52 
call $reserveStack 
set_local $temp 
get_global $MP 
get_local $temp 
i32.store 
get_global $MP 
get_global $SP 
i32.store offset=4 
get_global $MP 
i32.const 8 
i32.add 
set_local $localsStart 

 ;;Aqui empieza el cuerpo de la funcion

i32.const 12
get_global $MP
i32.const 8 
i32.add
i32.add
i32.const 777
i32.store
i32.const 12
get_global $MP
i32.const 8 
i32.add
i32.add

i32.load

call $print
i32.const 0
get_global $MP
i32.const 8 
i32.add
i32.add
get_local $localsStart
i32.const 28
i32.add
i32.const 4
call $copyn
i32.const 4
get_global $MP
i32.const 8 
i32.add
i32.add
get_local $localsStart
i32.const 32
i32.add
i32.const 4
call $copyn
i32.const 8
get_global $MP
i32.const 8 
i32.add
i32.add
get_local $localsStart
i32.const 36
i32.add
i32.const 4
call $copyn
i32.const 28
get_local $localsStart
i32.add
i32.const 16
get_global $MP
i32.const 8 
i32.add
i32.add
i32.const 12
call $copyn
i32.const 16
get_global $MP
i32.const 8 
i32.add
i32.add
get_local $returnDir
i32.const 12
call $copyn
call $freeStack 
get_local $returnDir
return 
call $freeStack 
return 
)

(func $funcion2 (type $_sig_i32ri32)
(param $returnDir i32) 
(result i32) 
(local $localsStart i32) 
(local $temp i32) 
i32.const 12 
call $reserveStack 
set_local $temp 
get_global $MP 
get_local $temp 
i32.store 
get_global $MP 
get_global $SP 
i32.store offset=4 
get_global $MP 
i32.const 8 
i32.add 
set_local $localsStart 

 ;;Aqui empieza el cuerpo de la funcion

get_local $returnDir
i32.const 2

i32.const 0
get_global $MP
i32.const 8 
i32.add
i32.add

i32.load

i32.mul
i32.store 
call $freeStack 
get_local $returnDir
return 
call $freeStack 
return 
)

(export "memory" (memory 0))
)
