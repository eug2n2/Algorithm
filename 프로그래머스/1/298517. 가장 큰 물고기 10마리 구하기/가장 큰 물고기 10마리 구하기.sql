select id, length
from fish_info
where length is not null
order by length desc, id 
limit 10;

