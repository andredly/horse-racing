SELECT us.first_name, ev.event_type, b.sum, b.date, hr.nick_name
FROM bet b LEFT JOIN user us ON b.user_id=us.id
LEFT JOIN event ev ON b.event_id=ev.id
LEFT JOIN horse hr ON ev.horse_id = hr.id
WHERE us.id=3;


SELECT r.id FROM race_detail r
  LEFT JOIN horse h ON r.horse_id = h.id WHERE h.nick_name='faster2'AND r.race_card_id=1;
SELECT horse.id,horse.nick_name FROM horse WHERE id=2;

UPDATE race_detail SET (date_finish,horse_result)=('2016-10-13 23:16:',2)
WHERE id=(SELECT r.id FROM race_detail r
  LEFT JOIN horse h ON r.horse_id = h.id WHERE h.nick_name='faster2'AND r.race_card_id=1);

DELETE FROM race_detail WHERE race_detail.id=65;