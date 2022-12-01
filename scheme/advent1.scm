(import (scheme base))
(import (scheme small))
(import (chibi))
(import (srfi 1))
(import (srfi 26))
(import (srfi 95))
(import (utils))

(define INPUT (readlines "../src/in/in1.txt"))

(define (group-calories ls)
    (let loop ((acc '(0)) (rest ls))
        (cond
            ((null? rest)
                acc)
            ((= -1 (car rest))
                (loop (cons 0 acc) (cdr rest)))
            (else
                (loop
                    (cons (+ (car rest) (car acc)) (cdr acc))
                    (cdr rest))))))

(->> INPUT
    (map
        (lambda (a)
            (if (equal? "" a)
                -1
                (string->number a))))
    group-calories
    ((cut sort <> >))
    ((lambda (grouped)
        (println "Answer 1: " (car grouped))
        (println "Answer 2: " (+ (car grouped) (cadr grouped) (caddr grouped))))))



