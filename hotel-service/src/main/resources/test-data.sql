INSERT INTO room_feature (name, description) VALUES
  ('Free Wi-Fi', 'Complimentary high-speed internet access'),
  ('Breakfast Included', 'Delicious breakfast served daily'),
  ('Air Conditioning', 'Climate control for your comfort');

INSERT INTO hotel (name, address, location_id, number_of_stars) VALUES
  ('Hotel A', 'Address A', (UNHEX('5fc03087d26511e7b8c683e29cd24f4c')), 4),
  ('Hotel B', 'Address B', (UNHEX('5fc03087d26511e7b8c683e29cd24f4c')), 5),
  ('Hotel C', 'Address C', (UNHEX('5fc03087d26511e7b8c683e29cd24f4c')), 5);

INSERT INTO room (number, capacity, is_available, room_type, hotel_id) VALUES
  (101, 2, true, 1, 1),
  (201, 3, true, 2, 1),
  (301, 1, true, 8, 2);

INSERT INTO included_room_feature (feature_id, room_id, quantity) VALUES
  (1, 1, 2),
  (2, 1, 1),
  (3, 2, 1);
