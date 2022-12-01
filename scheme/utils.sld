(define-library (utils)
    (export
        println
        readlines
        ->>
        thunk)
    (import
        (scheme base)
        (scheme small)
        (chibi)
        (srfi 1)
        (srfi 26))
    (begin
        (define-syntax ->> (syntax-rules ()
            ((->> value)
                value)
            ((->> value (fn args ...) rest ...)
                (->> (fn args ... value) rest ...))
            ((->> value fn rest ...)
                (->> (fn value) rest ...))))
        (define-syntax thunk (syntax-rules ()
            ((thunk body ...)
                (lambda () body ...))))
        (include "utils.scm")))