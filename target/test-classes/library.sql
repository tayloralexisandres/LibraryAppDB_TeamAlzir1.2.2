
select * from users;


select count(*) from book_borrow where is_returned=0;



select * from users;

select bc.name,count(*) from book_borrow bb
inner join books b on bb.book_id = b.id
inner join book_categories bc on b.book_category_id=bc.id group by name
order by 2 desc;

select *
from users;



select full_name, b.name, bb.borrowed_date
from users u
         inner join book_borrow bb on u.id = bb.user_id
         inner join books b on bb.book_id = b.id
where full_name = 'Test Student 56'
order by 3 desc;


select count(*) from book_borrow where is_returned=0;


