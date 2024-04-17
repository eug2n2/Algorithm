SELECT j.FLAVOR
FROM FIRST_HALF as h right outer Join JULY as j on h.FLAVOR = j.FLAVOR
Group by h.shipment_id
ORDER BY h.TOTAL_ORDER+(select sum(a.TOTAL_ORDER) from JULY as a Where a.FLAVOR= j.FLAVOR) DESC
limit 3;