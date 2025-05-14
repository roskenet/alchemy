## Start an instance example:
zkubectl run -i --tty busybox --namespace it-compliance --image=pierone.stups.zalan.do/torch/customer_cloak:pr-5-2     --restart=Never -- /bin/bash

## or Ubuntu:

zkubectl run felix-box --rm -i --tty --image ubuntu:19.10 --restart=Never -- /bin/bash

## or my own:

zkubectl run felix-box --rm -i --tty --image roskenet/flxbox:19.10 --restart=Never -- /bin/bash
