select count(*) as FISH_COUNT
from fish_info as i inner join fish_name_info as n
on i.fish_type = n.fish_type
where n.fish_name = "BASS" or n.fish_name = "SNAPPER"