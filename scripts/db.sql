create table yonetici(
    id serial primary key,
	ad_soyad varchar(50)
	
);
create table kampanya(
	id serial primary key,
	isim varchar(200),
	bas_sure varchar(200),
	bit_sure varchar(200)
);

create table magaza(
	id serial primary key,
	yonetici_id int,
	ad varchar(50),
	adres text,
	constraint yonetici_fk foreign key (yonetici_id) references yonetici(id)
);
create table musteri_hizmet(
	id serial primary key,
	magaza_id int,
	ad_soyad varchar(50),
	telefon text,
	constraint magaza_fk foreign key (magaza_id) references magaza(id)
);
create table kategori(
     id serial primary key,
	 ad varchar(30)
);
create table stok(
    id serial primary key,
	stok_adet int 
);
create table uyeler(
	id serial primary key,
	magaza_id int,
	ad_soyad varchar(50),
    adres text,
    e_posta text,
	telefon text,
	constraint magaza_fk foreign key (magaza_id) references magaza(id)
);
create table urunler(
	id serial primary key,
	kategori_id int,
	ad varchar(50),
    fiyat int,
	stok_id int,
	musteri_hizmet_id int,
	constraint stok_fk foreign key (stok_id) references stok(id),
	constraint musteri_hizmet_fk foreign key (musteri_hizmet_id) references musteri_hizmet(id),
	constraint kategori_fk foreign key (kategori_id) references kategori(id)
);
create table sepete_ekle(

	id serial primary key,
	sepet_urun_sayi int,
	urunler_id int,
	uyeler_id int,
	constraint urunler_fk foreign key (urunler_id) references urunler(id),
	constraint uyeler_fk foreign key (uyeler_id) references uyeler(id)
	
);
create table yorum_yapma(
	id serial primary key,
	urunler_id int,
	uyeler_id int,
	constraint urunler_fk foreign key(urunler_id) references urunler(id),
	constraint uyeler_fk foreign key(uyeler_id) references uyeler(id)

);

create table siparis_verme(
	id serial primary key,
	urunler_id int,
	uyeler_id int,
	constraint urunler_fk foreign key (urunler_id) references urunler(id),
	constraint uyeler_fk foreign key (uyeler_id) references uyeler(id)
);
create table faydalanma(
	id serial primary key,
	uyeler_id int,
	kampanya_id int,
	constraint uyeler_fk foreign key (uyeler_id) references uyeler(id),
    constraint kampanya_fk foreign key (kampanya_id) references kampanya(id)
);
create table document(
	id serial primary key,
	filepath varchar,
	filename varchar,
	filetype varchar
	
);