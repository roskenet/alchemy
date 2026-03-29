packloadall " Load all plugins
silent! helptags ALL

nmap <F2> :NERDTreeToggle<CR>

"colorscheme torte

set autochdir

set nocompatible
set clipboard=unnamed,unnamedplus

filetype indent plugin on
syntax on

"set laststatus=2

" Load powerline
"python3 from powerline.vim import setup as powerline_setup
"python3 powerline_setup()
"python3 del powerline_setup

set number
set showcmd

set autoindent
set shiftwidth=4
set softtabstop=4
set tabstop=4
set expandtab

" Special for gvim:
set guifont=MesloLGS\ NF\ 12
set guicursor+=a:blinkon0
set guioptions=

if &term =~ "xterm\\|rxvt"
  let &t_SI = "\<Esc>]12;green\x7"
  let &t_EI = "\<Esc>]12;orange\x7"
  silent !echo -ne "\033]12;orange\007"
  " reset cursor when vim exits
  autocmd VimLeave * silent !echo -ne "\033]112\007"
  " use \003]12;gray\007 for gnome-terminal and rxvt up to version 9.21
endif

" Set up persistent undo across all files.
set undofile
if !isdirectory(expand("$HOME/.vim/undodir"))
  call mkdir(expand("$HOME/.vim/undodir"), "p")
endif
set undodir=$HOME/.vim/undodir

" Set up global swap dir.
set directory=$HOME/.vim/swap//

" Transparent background for every colorscheme
" hi Normal guibg=NONE ctermbg=NONE
