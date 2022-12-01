(import (scheme base))
(import (scheme small))
(import (chibi))
(import (srfi 1))
(import (srfi 26))
(import (srfi 95))

(define (println . args) (if (null? args) (newline) (begin (display (car args)) (apply println (cdr args)))))

(define (readlines filename)
    (call-with-input-file filename
        (lambda (p)
            (let loop ((line (read-line p))
                (result '()))
            (if (eof-object? line)
                (reverse result)
                (loop (read-line p) (cons line result)))))))

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

(define nums
    (map
        (lambda (a)
            (if (equal? "" a)
                -1
                (string->number a)))
        INPUT))

(define grouped (group-calories nums))

(println "Answer 1: " (car (sort grouped >)))

(println "Answer 2: " (let ((sorted (sort grouped >))) (+ (car sorted) (cadr sorted) (caddr sorted))))