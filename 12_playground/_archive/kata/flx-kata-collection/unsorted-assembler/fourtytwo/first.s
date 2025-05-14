# My first program

.globl _start
.section .text

_start:
    movq $60, %rax
    movq $42, %rdi
    syscall
