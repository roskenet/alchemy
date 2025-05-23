@.str = private constant [15 x i8] c"Hello, World!\0A\00"

declare i32 @puts(i8* nocapture) nounwind

define i32 @main() {
entry:
  %cast = getelementptr [15 x i8], [15 x i8]* @.str, i64 0, i64 0
  %call = call i32 @puts(i8* %cast)
  ret i32 0
}
