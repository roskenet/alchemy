# My first program
# This is example is from 
# "Learn to Program with Assembly"

.globl _start
.section .text

_start:
    movq $60, %rax
    movq $42, %rdi
    syscall
