select b.name,isbn,author from books b where b.name = 'Pamela';

select b.name from books b where b.name = 'Pamela';


select *
from users;


select book_id, name
from book_borrow bb
         inner join books b on bb.book_id = b.id
where book_id = 847;

-- US2
select count(*)
from book_borrow
where is_returned = 0;

-- US3
select name
from book_categories;

-- US4
select * from books where name = 'Limon5';

-- US 5
select bc.name, count(*)
from book_borrow bb
         inner join books b on bb.book_id = b.id
         inner join book_categories bc on b.book_category_id = bc.id
group by bc.name
order by 2 desc;

-- US 6
select name, author, isbn
from books
where name = 'Head First Java';

-- US7
select b.name from books b join book_borrow bb on b.id = bb.book_id join users u on bb.user_id = u.id where b.name = 'Limon6';