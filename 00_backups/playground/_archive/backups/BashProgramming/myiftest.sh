#!/usr/bin/env bash

OLD_HASH=${1:-EMPTY}
NEW_HASH=${2:-EMPTY}

if [ $OLD_HASH == $NEW_HASH ]
then
    echo "They are equal"
    exit 0
fi
echo "$OLD_HASH and $NEW_HASH are not equal"
