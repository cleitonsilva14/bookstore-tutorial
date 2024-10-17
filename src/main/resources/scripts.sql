INSERT INTO public.tb_publisher
VALUES
(gen_random_uuid(), 'Alta Books'),
(gen_random_uuid(), 'Pearson');

INSERT INTO public.tb_author( id, name)
VALUES
(gen_random_uuid(), 'Eric Evans'),
(gen_random_uuid(), 'Paul Deitel'),
(gen_random_uuid(), 'Harvey Deitel');

--
SELECT * FROM tb_publisher;
SELECT * FROM tb_author;

--
SELECT * FROM tb_book;
SELECT * FROM tb_book_author;
SELECT * FROM tb_review;




