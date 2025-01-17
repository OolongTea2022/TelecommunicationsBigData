create  table  Signal_Strength(
id  bigint  not null,
user_lon varchar(200),
user_lat varchar(200),
network_name varchar(200),
rssi bigint,
network_type varchar(200),
time_index bigint,
landmark varchar(200)
CONSTRAINT Signal_Strength PRIMARY KEY(id)
);

create  table NWQuality(
id bigint not null,
GpsLat  varchar(200),
GpsLon  varchar(200),
NWOperator  varchar(200),
ULSpeed  double,
DLSpeed  double,
Latency  double,
province  varchar(200),
dayTime bigint,
NWType  varchar(200),
landmark  varchar(200),
CompanyModel  varchar(200)
CONSTRAINT NWQuality PRIMARY KEY(id)
);


create table IF NOT EXISTS DataConnection (
id bigint not null,
user_lat  double,
user_lon  double,
network_name   varchar(200),
network_type   varchar(200),
ping_value  varchar(200),
mobile_network_type   varchar(200),
time_index_client bigint
CONSTRAINT DataConnection PRIMARY KEY(id)
);

create table if not exists app_traffic(
id bigint not null,
user_lon varchar(200),
user_lat varchar(200),
upload_traffic double,
download_traffic double,
package_name varchar(200),
network_name varchar(200),
app_name varchar(200),
os varchar(200),
os_version varchar(200),
company  varchar(200),
start_time varchar(200),
end_time varchar(200),
network_type  varchar(200) ,
allMobileTraffic  varchar(200),
date bigint,
Landmark varchar(200),
companyModel varchar(200),
os_andversion varchar(200)
CONSTRAINT app_traffic PRIMARY KEY(id));
