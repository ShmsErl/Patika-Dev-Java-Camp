package com.adventuregame.Business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.adventuregame.Entity.Player;
import com.adventuregame.Entity.Abstract.Armor;
import com.adventuregame.Entity.Abstract.CharacterGame;
import com.adventuregame.Entity.Abstract.Item;
import com.adventuregame.Entity.Abstract.Location;
import com.adventuregame.Entity.Abstract.Weapon;
import com.adventuregame.Entity.Concretes.Inventory;
import com.adventuregame.Entity.Concretes.Characters.Archer;
import com.adventuregame.Entity.Concretes.Characters.Knight;
import com.adventuregame.Entity.Concretes.Characters.Samurai;
import com.adventuregame.Entity.Concretes.Items.Gun;
import com.adventuregame.Entity.Concretes.Items.HighArmor;
import com.adventuregame.Entity.Concretes.Items.LightArmor;
import com.adventuregame.Entity.Concretes.Items.MediumArmor;
import com.adventuregame.Entity.Concretes.Items.Rifle;
import com.adventuregame.Entity.Concretes.Items.Sword;
import com.adventuregame.Entity.Concretes.Maps.NormalLocation.SafeHouse;
import com.adventuregame.Entity.Concretes.Maps.NormalLocation.ToolStore;
import com.adventuregame.Entity.Concretes.Maps.WarLocation.Cavern;
import com.adventuregame.Entity.Concretes.Maps.WarLocation.Forest;
import com.adventuregame.Entity.Concretes.Maps.WarLocation.Minel;
import com.adventuregame.Entity.Concretes.Maps.WarLocation.River;
import com.adventuregame.Entity.Concretes.Monsters.Bear;
import com.adventuregame.Entity.Concretes.Monsters.Snake;
import com.adventuregame.Entity.Concretes.Monsters.Vampir;
import com.adventuregame.Entity.Concretes.Monsters.Zombie;

public class Game {
	Scanner scanner = new Scanner(System.in);
	Player player = new Player();
	Weapon weapon;
	Armor armor;
	JFrame frame = new JFrame("Adventure Game");
	JLabel label = new JLabel("Oyuna Başlamak İçin Play Tuşuna basın");
	JFrame safeHome = new JFrame("SafeHouse");
	Location location;

	public void start() {

		System.out.println("Advuntere Time Oyunu Başlatılıyor Lütfen Bekleyin ...\n\n" + "Yükleniyor...\n"
				+ "Advuntre Time Hoşgeldin (:\n\n" + "Oyuna Başlamak İçin Enter Tuşuna basın..."
				+ player.getInventory().getLoots().toString());
		scanner.nextLine();

		JButton play = new JButton("Play");
		JLabel label = new JLabel("Oyuna Başlamak\n İçin Play\n Tuşuna basın");
		label.setBounds(130, 120, 200, 30);
		frame.setLocation(300,250);
		safeHome.setSize(500, 300);
		frame.setSize(400, 400);
		play.setBounds(130, 150, 95, 30);
		frame.add(play);
		frame.add(label);

		frame.setLayout(null);
		safeHome.setLayout(null);
		frame.setVisible(true);

		play.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				play.setVisible(false);
				frame.setVisible(false);
				play();

				label.setText("Karakter Şeçimi Yap !! " + player.getPlayerName());

				JButton selectChar = new JButton("Karakter Şeç !!");
				selectChar.setBounds(130, 170, 120, 30);

				frame.add(selectChar);
				selectChar.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						label.setBounds(130, 10, 180, 30);
						selectChar.setVisible(false);
						selectCharacter();
					}
				});

			}
		});

	}

	public void play() {

		System.out.println("Oyuna Devam Etmek İçin Kendinize Bir İsim Belirleyin : \n  ");
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		player.setPlayerName(scanner.nextLine());
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");

		System.out.println(player.getPlayerName() + ":  Şimdi Sırada Karakter Seçimi var !!  \n ");
		frame.setVisible(true);
	}

	public void selectCharacter() {
		CharacterGame.characterInfo(new Samurai());
		CharacterGame.characterInfo(new Knight());
		CharacterGame.characterInfo(new Archer());

		JButton samurai = new JButton("Samuray");
		JButton archer = new JButton("Okçu");
		JButton knight = new JButton("Savaşçı");
		samurai.setBounds(130, 50, 120, 30);
		archer.setBounds(130, 90, 120, 30);
		knight.setBounds(130, 130, 120, 30);
		frame.add(samurai);
		frame.add(archer);
		frame.add(knight);

		samurai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				player.initPlayer(new Samurai(), player);
				samurai.setVisible(false);
				archer.setVisible(false);
				knight.setVisible(false);
				frame.setVisible(false);
				selectMap();

			}
		});

		archer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				player.initPlayer(new Archer(), player);
				samurai.setVisible(false);
				archer.setVisible(false);
				knight.setVisible(false);
				frame.setVisible(false);
				selectMap();

			}
		});

		knight.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				player.initPlayer(new Knight(), player);
				samurai.setVisible(false);
				archer.setVisible(false);
				knight.setVisible(false);
				frame.setVisible(false);
				selectMap();

			}
		});

	}

	public void selectMap() {
		label.setText("Harita Seçimi Yap");
		Random random = new Random();
		int a = random.nextInt(4) + 1;
		JButton safeHouse = new JButton("Safe House");
		safeHouse.setBounds(130, 50, 120, 30);
		frame.add(safeHouse);
		JButton exit = new JButton("Çıkış Yap");
		safeHome.add(exit);
		exit.setBounds(170, 110, 120, 30);
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(true);
				safeHome.setVisible(false);
				exit.setVisible(false);

			}
		});
		safeHouse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				location = new SafeHouse(player);
				location.onLocation();

				safeHome.setVisible(true);
				frame.setVisible(false);
				player.setHealty(100);

				System.out.println(
						"Güvenli Evdesiniz " + "Canınız Fullendi %\n " + player.getHealty() + " % .. . . .. . ");
				safeHome.add(label);

			}
		});

		JButton toolStore = new JButton("Tool Store");
		toolStore.setBounds(130, 90, 120, 30);
		frame.add(toolStore);
		toolStore.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				exit.setVisible(true);
				exit.setBounds(180, 220, 120, 30);
				location = new ToolStore(player);
				location.onLocation();
				safeHome.setVisible(true);
				selectItem();

			}
		});

		JButton river = new JButton("River");
		river.setBounds(130, 130, 120, 30);
		frame.add(river);
		river.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				location = new River(player, a);
				location.onLocation();

				boolean result = player.inventoryCheck(player, location);
				if (result == false) {

					System.out.println("Bu harita görevi tamalanmış " + player.getInventory().getLoots().toString());
				} else {

					CharacterGame.characterInfo(new Bear());
					combat(player, new Bear(), a);
				}

			}
		});

		JButton forest = new JButton("Forest");
		forest.setBounds(130, 170, 120, 30);
		frame.add(forest);
		forest.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				location = new Forest(player, a);
				location.onLocation();
				boolean result = player.inventoryCheck(player, location);
				if (result == false) {

					System.out.println("Bu harita görevi tamalanmış " + player.getInventory().getLoots().toString());
				} else {

					CharacterGame.characterInfo(new Vampir());
					combat(player, new Vampir(), a);

				}

			}
		});

		JButton cavern = new JButton("Cavern");
		cavern.setBounds(130, 210, 120, 30);
		frame.add(cavern);
		cavern.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				location = new Cavern(player, a);
				location.onLocation();
				boolean result = player.inventoryCheck(player, location);
				if (result == false) {

					System.out.println("Bu harita görevi tamalanmış " + player.getInventory().getLoots().toString());
				} else {
					CharacterGame.characterInfo(new Zombie());
					combat(player, new Zombie(), a);

				}

			}
		});
		JButton minel = new JButton("Minel");
		minel.setBounds(130, 250, 120, 30);
		frame.add(minel);
		minel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int monsterQuantity = random.nextInt(5)+1;
				location = new Minel(player, monsterQuantity);
				location.onLocation();
				boolean result = player.inventoryCheck(player, location);
				if (result == false) {

					System.out.println("Bu harita görevi tamalanmış " + player.getInventory().getLoots().toString());
				} else {
					CharacterGame.characterInfo(new Snake());
					combat(player, new Snake(), monsterQuantity);

				}
				
			}
		});
		

		System.out.println("\nOyuna Başlamana Az Kaldı Sıra Harita Seçiminde ... ");
		frame.setVisible(true);

	}

	public void selectItem() {

		JLabel selectItem = new JLabel("Almak İstediğiniz İtemleri Seçin\n" + " Total Altın : " + player.getMoney());
		JButton gun = new JButton("Tabanca");
		gun.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				weapon = new Gun();

				player.isCheckWeapon(player, weapon);

			}
		});
		JButton knife = new JButton("Kılıç");
		knife.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				weapon = new Sword();

				player.isCheckWeapon(player, weapon);

			}
		});
		JButton rifle = new JButton("Tüfek");
		rifle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				player.setMoney(50);
				weapon = new Rifle();

				player.isCheckWeapon(player, weapon);

			}
		});

		JButton armor1 = new JButton("Hafif Seviye Zırh");
		armor1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				player.setMoney(50);
				armor = new LightArmor();

				player.isCheckArmor(player, armor);

			}
		});

		JButton armor2 = new JButton("Orta Seviye Zırh");

		armor2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				player.setMoney(50);
				armor = new MediumArmor();

				player.isCheckArmor(player, armor);

			}
		});
		JButton armor3 = new JButton("Yüksek Seviye Zırh");
		armor3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				player.setMoney(50);
				armor = new HighArmor();

				player.isCheckArmor(player, armor);

			}
		});

		armor1.setBounds(250, 100, 150, 30);
		armor2.setBounds(250, 140, 150, 30);
		armor3.setBounds(250, 180, 150, 30);
		knife.setBounds(80, 100, 150, 30);
		gun.setBounds(80, 140, 150, 30);
		rifle.setBounds(80, 180, 150, 30);
		selectItem.setBounds(160, 50, 200, 30);
		safeHome.add(gun);
		safeHome.add(knife);
		safeHome.add(rifle);
		safeHome.add(armor1);
		safeHome.add(armor2);
		safeHome.add(armor3);
		safeHome.add(selectItem);

	}

	public String firstAttack(Player player, CharacterGame characterGame) {
		String[] players = { player.getPlayerName(), characterGame.getName() };
		Random random = new Random();

		int personId = random.nextInt(players.length);

		return players[personId];
	}

	public void combat(Player player, CharacterGame characterGame, int a) {
		frame.setVisible(false);
		String firstAttack = firstAttack(player, characterGame);

		System.out.println("press enter to start the battle ");
		String enter = scanner.nextLine();

		switch (enter) {
		case "":
			for (int i = 1; i <= a; i++) {

				characterGame.setHealty(100);
				System.out.println((i) + ".Canavar ile şavaş Başladı . ");
				while (player.getHealty() > 0 && characterGame.getHealty() > 0) {

					if (firstAttack.equals(player.getPlayerName())) {
						characterGame.setHealty(characterGame.getHealty() - player.getDamage() );
						System.out.println(player.getPlayerName() + " Saldırdı ve hasarı " + player.getDamage()
								+ " Canavar Canı " + characterGame.getHealty());
						System.out.println(
								"-----------------------------------------------------------------------------------------------");
						if (characterGame.getHealty() <= 0) {

							break;
						}

						player.setHealty(player.getHealty() - (characterGame.getDamage()));
						System.out.println(characterGame.getName() + " Saldırdı ve hasarı " + characterGame.getDamage()
								+ " Player Can değeri : " + player.getHealty());
						System.out.println(
								"-----------------------------------------------------------------------------------------------");
						if (player.getHealty() <= 0) {

							break;
						}
					} else {

						player.setHealty(player.getHealty() - (characterGame.getDamage()));
						System.out.println(characterGame.getName() + " Saldırdı ve hasarı " + characterGame.getDamage()
								+ " Player Can değeri : " + player.getHealty());
						System.out.println(
								"-----------------------------------------------------------------------------------------------");
						if (player.getHealty() <= 0) {

							break;
						}
						characterGame.setHealty(characterGame.getHealty() - (player.getDamage()));
						System.out.println(player.getPlayerName() + " Saldırdı ve hasarı " + player.getDamage()
								+ " Canavar Canı " + characterGame.getHealty());
						System.out.println(
								"-----------------------------------------------------------------------------------------------");
						if (characterGame.getHealty() <= 0) {

							break;
						}

					}

				}
				if (player.getHealty() > 0 && i == a) {

					player.getInventory().getLoots().add(location.getLootName());
					player.setMoney(player.getMoney() + characterGame.getMoney());
					System.out.println(" Tebriklerr " + location.getName() + " Bölümü Başarı İle Geçtin.. " + a
							+ " adet " + characterGame.getName() + " Öldürdünüz" + " Kazandığınız Toplam Ödül : "
							+ (characterGame.getMoney() * a) + " Altın , \n Harita Ekranına Yönlendiriliyorsunuz ....\n"
							+ player.getInventory().getLoots().toString());
					selectMap();

				}

				else if (player.getHealty() > 0 && a != 1) {

					player.setMoney(player.getMoney() + characterGame.getMoney());
					System.out.println(i + "."+ characterGame.getName() +" Yendiniz ve " + characterGame.getMoney() + " Altın Ödülü Aldınız "
							+ " Devam Etmek İstiyor musunuz ? { E / H }");
					String isContunie = scanner.nextLine().toUpperCase();

					switch (isContunie) {
					case "E":

						continue;

					case "H":
						a = 0;
						selectMap();
						System.out.println(player.getMoney());

						break;
					default:
						a = 0;
						selectMap();
						System.out.println(player.getMoney());

					}

				} else if (player.getHealty() == 0 || a == 1) {

					a = 0;
					System.out.println(i + "." + characterGame.getName()
							+ ", Yenildiniz ve Oyunu Kaybettiniz... Bu Sebeble Harita Ekranına Döndürülüyorsunuz ... "
							+ player.getMoney() + " Altın Paranız Mevcuttur. ");
					selectMap();

				}
			}
			break;
		case "E":
			System.out.println("Oyun Sonlandırılıyor Harita Ekranına Yönlendiriliyorsunuz");
			selectMap();
			break;

		default:
			selectMap();
			break;

		}

	}

}