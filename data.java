package org.uma.jmetal.algorithm.multiobjective.aRankabili;

public class data {

	/*
	{{0.4,0.5,0.5,0.6},{0.2,0.3,0.4,0.5}, {0.2,0.3,0.4,0.5}, {0.8,0.9,1.0,1.0}}, 
	{{0.7,0.8,0.8,0.9},  {0.4,0.5,0.5,0.6},{0.4,0.5,0.5,0.6},{0.5,0.6,0.7,0.8}}, 
	{{0.2,0.3,0.4,0.5}, {0.8,0.9,1.0,1.0},  {0.5,0.6,0.7,0.8},  {0.7,0.8,0.8,0.9}}, 
	{{0.1,0.2,0.2,0.3}, {0.0,0.0,0.1,0.2},  {0.1,0.2,0.2,0.3}, {0.2,0.3,0.4,0.5}} 

	{{0.1,0.2,0.2,0.3}, {0.7,0.8,0.8,0.9},  {0.2,0.3,0.4,0.5}, {0.4,0.5,0.5,0.6}}, 
	{{0.4,0.5,0.5,0.6},{0.7,0.8,0.8,0.9},  {0.5,0.6,0.7,0.8},  {0.4,0.5,0.5,0.6}}, 
	{{0.8,0.9,1.0,1.0},  {0.2,0.3,0.4,0.5}, {0.8,0.9,1.0,1.0},  {0.8,0.9,1.0,1.0}}, 
	{{0.2,0.3,0.4,0.5}, {0.5,0.6,0.7,0.8},  {0.4,0.5,0.5,0.6},{0.5,0.6,0.7,0.8}} 

	{{0.2,0.3,0.4,0.5}, {0.4,0.5,0.5,0.6},{0.7,0.8,0.8,0.9},  {0.5,0.6,0.7,0.8}}, 
	{{0.8,0.9,1.0,1.0},  {0.1,0.2,0.2,0.3}, {0.7,0.8,0.8,0.9},  {0.7,0.8,0.8,0.9}}, 
	{{0.1,0.2,0.2,0.3}, {0.7,0.8,0.8,0.9},  {0.7,0.8,0.8,0.9},  {0.7,0.8,0.8,0.9}}, 
	{{0.4,0.5,0.5,0.6},{0.1,0.2,0.2,0.3}, {0.7,0.8,0.8,0.9},  {0.7,0.8,0.8,0.9}} 

	 Palm oil------------
	{{0.7,0.8,0.8,0.9},  {0.5,0.6,0.7,0.8},  {0.5,0.6,0.7,0.8},  {0.7,0.8,0.8,0.9}}, 
	{{0.1,0.2,0.2,0.3}, {0.2,0.3,0.4,0.5}, {0.2,0.3,0.4,0.5}, {0.1,0.2,0.2,0.3}},
	{{0.5,0.6,0.7,0.8},  {0.4,0.5,0.5,0.6},{0.4,0.5,0.5,0.6},{0.5,0.6,0.7,0.8}}, 

	{{0.7,0.8,0.8,0.9},  {0.5,0.6,0.7,0.8},  {0.5,0.6,0.7,0.8},  {0.5,0.6,0.7,0.8}}, 
	{{0.1,0.2,0.2,0.3}, {0.1,0.2,0.2,0.3}, {0.1,0.2,0.2,0.3}, {0.1,0.2,0.2,0.3}},
	{{0.4,0.5,0.5,0.6},{0.4,0.5,0.5,0.6},{0.7,0.8,0.8,0.9},  {0.4,0.5,0.5,0.6}},

	{{0.8,0.9,1.0,1.0},  {0.8,0.9,1.0,1.0},  {0.7,0.8,0.8,0.9},  {0.7,0.8,0.8,0.9}}, 
	{{0.5,0.6,0.7,0.8},  {0.4,0.5,0.5,0.6},{0.2,0.3,0.4,0.5}, {0.2,0.3,0.4,0.5}}, 
	{{0.5,0.6,0.7,0.8},  {0.4,0.5,0.5,0.6},{0.7,0.8,0.8,0.9},  {0.2,0.3,0.4,0.5}}, 

	 Sunflower & soybean oil
	{{0.8,0.9,1.0,1.0},  {0.4,0.5,0.5,0.6},{0.8,0.9,1.0,1.0},  {0.4,0.5,0.5,0.6}}, 
	{{0.5,0.6,0.7,0.8},  {0.5,0.6,0.7,0.8},  {0.5,0.6,0.7,0.8},  {0.5,0.6,0.7,0.8}}, 
	{{0.1,0.2,0.2,0.3}, {0.8,0.9,1.0,1.0},  {0.4,0.5,0.5,0.6},{0.4,0.5,0.5,0.6}}, 

	{{0.7,0.8,0.8,0.9},  {0.2,0.3,0.4,0.5}, {0.7,0.8,0.8,0.9},  {0.4,0.5,0.5,0.6}}, 
	{{0.2,0.3,0.4,0.5}, {0.4,0.5,0.5,0.6},{0.0,0.0,0.1,0.2},  {0.4,0.5,0.5,0.6}}, 
	{{0.1,0.2,0.2,0.3}, {0.2,0.3,0.4,0.5}, {0.2,0.3,0.4,0.5}, {0.4,0.5,0.5,0.6}}, 

	{{0.7,0.8,0.8,0.9},  {0.7,0.8,0.8,0.9},  {0.5,0.6,0.7,0.8},  {0.5,0.6,0.7,0.8}}, 
	{{0.5,0.6,0.7,0.8},  {0.2,0.3,0.4,0.5}, {0.0,0.0,0.1,0.2},  {0.0,0.0,0.1,0.2}}, 
	{{0.7,0.8,0.8,0.9},  {0.1,0.2,0.2,0.3}, {0.5,0.6,0.7,0.8},  {0.5,0.6,0.7,0.8}}, 
	*/
	
	/*
	 F MP MP VG
G F F MG 
MP VG MG G 
P VP P MP 

P G MP F 
F G MG F 
VG MP VG VG
MP MG F MG 

MP F G MG 
VG P G G 
P G G G 
F P G G 

 Palm oil------------
G MG MG G 
P MP MP P 
MG F F MG 

G MG MG MG 
P P P P 
F F G F 

VG VG G G 
MG F MP MP 
MG F G MP 

 Sunflower & soybean oil
VG F VG F 
MG MG MG MG 
P VG F F 

G MP G F 
MP F VP F 
P MP MP F 

G G MG MG 
MG MP VP VP 
G P MG MG 
	 */
	
	/*
H H MH ML
VH MH H M
H VH MH MH
	 
	{{0.7,0.8,0.8,0.9},  {0.7,0.8,0.8,0.9},  {0.5,0.6,0.7,0.8}, {0.2,0.3,0.4,0.5}}, 
	{{0.8,0.9,1.0,1.0},  {0.5,0.6,0.7,0.8}, {0.7,0.8,0.8,0.9},  {0.4,0.5,0.5,0.6}}, 
	{{0.7,0.8,0.8,0.9},  {0.8,0.9,1.0,1.0},  {0.5,0.6,0.7,0.8}, {0.5,0.6,0.7,0.8}} 
	*/
}