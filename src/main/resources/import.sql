--
-- Sample dataset containing a number of Hotels in various Cities across the world.
--
insert into city(country, name, state, map) values ('Australia', 'Brisbane', 'Queensland', '-27.470933, 153.023502')
insert into city(country, name, state, map) values ('Australia', 'Melbourne', 'Victoria', '-37.813187, 144.96298')
insert into city(country, name, state, map) values ('Australia', 'Sydney', 'New South Wales', '-33.868901, 151.207091')
insert into city(country, name, state, map) values ('Israel', 'Tel Aviv', '', '32.066157, 34.777821')
insert into city(country, name, state, map) values ('Japan', 'Tokyo', '', '35.689488, 139.691706')
insert into city(country, name, state, map) values ('Spain', 'Barcelona', 'Catalunya', '41.387917, 2.169919')
insert into city(country, name, state, map) values ('Switzerland', 'Neuchatel', '', '46.992979, 6.931933')
insert into city(country, name, state, map) values ('UK', 'Bath', 'Somerset', '51.381428, -2.357454')
insert into city(country, name, state, map) values ('UK', 'London', '', '51.500152, -0.126236')
insert into city(country, name, state, map) values ('UK', 'Southampton', 'Hampshire', '50.902571, -1.397238')
insert into city(country, name, state, map) values ('USA', 'Atlanta', 'GA', '33.748995, -84.387982')
insert into city(country, name, state, map) values ('USA', 'Chicago', 'IL', '41.878114, -87.629798')
insert into city(country, name, state, map) values ('USA', 'Eau Claire', 'WI', '44.811349, -91.498494')
insert into city(country, name, state, map) values ('USA', 'Hollywood', 'FL', '26.011201, -80.14949')
insert into city(country, name, state, map) values ('USA', 'Miami', 'FL', '25.788969, -80.226439')
insert into city(country, name, state, map) values ('USA', 'Melbourne', 'FL', '28.083627, -80.608109')
insert into city(country, name, state, map) values ('USA', 'New York', 'NY', '40.714353, -74.005973')

insert into city(country, name, state, map) values ('USA', 'Salt Lake', 'UT', '28.034462, -80.588665')
insert into city(country, name, state, map) values ('USA', 'San Francisco', 'CA', '37.77493, -122.419415')
insert into city(country, name, state, map) values ('USA', 'Seattle', 'WA', '38.895112, -77.036366')


insert into city(country, name, state, map) values ('Canada', 'Winnipeg', 'Manitoba', '45.508889, -73.554167')
insert into owner(id, city_id, name) values (1, 4, 'Andrea Thacker')
insert into project(id, project_name,  owner_id ) values(1, 'Project Info',1 )
insert into guideline(id, project_id, title, value) values(1, 1, 'Quality', 'Unit Testing prior to checkin.')
