\NeedsTeXFormat{LaTeX2e}
\ProvidesClass{flxtext}[2026/05/17 Custom essay document class]

\LoadClass[11pt,a4paper,twoside]{article}

% Required packages
\RequirePackage[
    top=1.5in,
    bottom=1.5in,
    inner=1.2in,
    outer=1.2in,
    marginparwidth=1in,
    marginparsep=0.15in
]{geometry}
\RequirePackage[dvipsnames]{xcolor}
\RequirePackage{fancyhdr}
\RequirePackage{titling}
\RequirePackage[hidelinks]{hyperref}
\RequirePackage{enumitem}
\RequirePackage{listings}
\RequirePackage{graphicx}

\makeatletter
\renewenvironment{abstract}{%
  \if@twocolumn
    \section*{\abstractname}%
  \else
    \small
    \begin{center}%
      {\bfseries\color{SectionColor} \abstractname\vspace{-.5em}\vspace{\z@}}%
    \end{center}%
    \list{}{\listparindent 1.5em%
            \itemindent    0pt%
            \rightmargin   \leftmargin
            \parsep        \z@ \@plus\p@}%
    \item\relax\sffamily
  \fi
}{%
  \if@twocolumn\else\endlist\fi
}
\makeatother

\lstset{
    language=Java,
    basicstyle=\ttfamily\small,
    keywordstyle=\color{blue},
    stringstyle=\color{red},
    commentstyle=\color{gray},
    breaklines=true,
    frame=none,
    captionpos=b,
    numbers=left,
    numbersep=5pt,
    numberstyle=\tiny\color{gray},
    xleftmargin=2em,
    xrightmargin=2em,
    showstringspaces=false,
    tabsize=4,
}

% Typography (adobepro handles font families and some definitions)
\RequirePackage{adobepro}

% Colors
\definecolor{TitleColor}{RGB}{30,30,30}
\definecolor{SectionColor}{RGB}{40,40,40}

% Title Styling (override or extend adobepro)
\pretitle{\begin{center}\color{TitleColor}\rule{\textwidth}{0.4pt}\\[1em]\displaytitlefont}
\posttitle{\\[1em]\rule{\textwidth}{0.4pt}\par\end{center}\vskip 2em}
\preauthor{\begin{center}\large\itshape}
\postauthor{\end{center}\vskip 1em}

% Section Styling (redefining to use color)
\titleformat{\section}
  {\sectionfont\color{SectionColor}}
  {\thesection}{1em}{}

% Header and Footer
\pagestyle{fancy}
\fancyhf{}
\fancyhead[LE,RO]{\small\thepage}
\fancyhead[RE]{\small\scshape\theauthor}
\fancyhead[LO]{\small\scshape\thetitle}
\renewcommand{\headrulewidth}{0.4pt}

\endinput
