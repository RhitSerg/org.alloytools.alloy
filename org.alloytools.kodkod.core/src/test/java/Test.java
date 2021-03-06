import java.util.Arrays;
import java.util.List;

import kodkod.ast.Decls;
import kodkod.ast.Expression;
import kodkod.ast.Formula;
import kodkod.ast.Relation;
import kodkod.ast.Variable;
import kodkod.ast.operator.FormulaOperator;
import kodkod.engine.Solution;
import kodkod.engine.Solver;
import kodkod.engine.config.Options;
import kodkod.engine.satlab.SATFactory;
import kodkod.instance.Bounds;
import kodkod.instance.TupleFactory;
import kodkod.instance.TupleSet;
import kodkod.instance.Universe;

public final class Test {

	public static void main(String[] args) throws Exception {

		Relation x0 = Relation.unary("Int/min");
		Relation x1 = Relation.unary("Int/zero");
		Relation x2 = Relation.unary("Int/max");
		Relation x3 = Relation.nary("Int/next", 2);
		Relation x4 = Relation.unary("seq/Int");
		Relation x5 = Relation.unary("String");
		Relation x6 = Relation.unary("this/Null");
		Relation x7 = Relation.unary("this/Str");
		Relation x8 = Relation.unary("this/N0");
		Relation x9 = Relation.unary("this/N1");
		Relation x10 = Relation.unary("this/N2");
		Relation x11 = Relation.unary("this/Node remainder");
		Relation x12 = Relation.unary("this/This");
		Relation x13 = Relation.unary("this/List remainder");
		Relation x14 = Relation.unary("this/far0");
		Relation x15 = Relation.unary("this/far1");
		Relation x16 = Relation.unary("this/mid0");
		Relation x17 = Relation.unary("this/mid1");
		Relation x18 = Relation.unary("this/near0");
		Relation x19 = Relation.unary("this/near1");
		Relation x20 = Relation.nary("this/Node.data", 2);
		Relation x21 = Relation.nary("this/Node.next", 2);
		Relation x22 = Relation.nary("this/Node.next0", 2);
		Relation x23 = Relation.nary("this/Node.next1", 2);
		Relation x24 = Relation.nary("this/Node.next3", 2);
		Relation x25 = Relation.nary("this/List.head", 2);
		Relation x26 = Relation.nary("this/List.head0", 2);

		List<String> atomlist = Arrays.asList("-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8", "0", "1", "2", "3", "4",
				"5", "6", "7", "N0$0", "N1$0", "N2$0", "Null$0", "Str$0", "Str$1", "Str$2", "This$0");

		Universe universe = new Universe(atomlist);
		TupleFactory factory = universe.factory();
		Bounds bounds = new Bounds(universe);

		TupleSet x0_upper = factory.noneOf(1);
		x0_upper.add(factory.tuple("-8"));
		bounds.boundExactly(x0, x0_upper);

		TupleSet x1_upper = factory.noneOf(1);
		x1_upper.add(factory.tuple("0"));
		bounds.boundExactly(x1, x1_upper);

		TupleSet x2_upper = factory.noneOf(1);
		x2_upper.add(factory.tuple("7"));
		bounds.boundExactly(x2, x2_upper);

		TupleSet x3_upper = factory.noneOf(2);
		x3_upper.add(factory.tuple("-8").product(factory.tuple("-7")));
		x3_upper.add(factory.tuple("-7").product(factory.tuple("-6")));
		x3_upper.add(factory.tuple("-6").product(factory.tuple("-5")));
		x3_upper.add(factory.tuple("-5").product(factory.tuple("-4")));
		x3_upper.add(factory.tuple("-4").product(factory.tuple("-3")));
		x3_upper.add(factory.tuple("-3").product(factory.tuple("-2")));
		x3_upper.add(factory.tuple("-2").product(factory.tuple("-1")));
		x3_upper.add(factory.tuple("-1").product(factory.tuple("0")));
		x3_upper.add(factory.tuple("0").product(factory.tuple("1")));
		x3_upper.add(factory.tuple("1").product(factory.tuple("2")));
		x3_upper.add(factory.tuple("2").product(factory.tuple("3")));
		x3_upper.add(factory.tuple("3").product(factory.tuple("4")));
		x3_upper.add(factory.tuple("4").product(factory.tuple("5")));
		x3_upper.add(factory.tuple("5").product(factory.tuple("6")));
		x3_upper.add(factory.tuple("6").product(factory.tuple("7")));
		bounds.boundExactly(x3, x3_upper);

		TupleSet x4_upper = factory.noneOf(1);
		x4_upper.add(factory.tuple("0"));
		x4_upper.add(factory.tuple("1"));
		x4_upper.add(factory.tuple("2"));
		x4_upper.add(factory.tuple("3"));
		bounds.boundExactly(x4, x4_upper);

		TupleSet x5_upper = factory.noneOf(1);
		bounds.boundExactly(x5, x5_upper);

		TupleSet x6_upper = factory.noneOf(1);
		x6_upper.add(factory.tuple("Null$0"));
		bounds.boundExactly(x6, x6_upper);

		TupleSet x7_upper = factory.noneOf(1);
		x7_upper.add(factory.tuple("Str$0"));
		x7_upper.add(factory.tuple("Str$1"));
		x7_upper.add(factory.tuple("Str$2"));
		bounds.bound(x7, x7_upper);

		TupleSet x8_upper = factory.noneOf(1);
		x8_upper.add(factory.tuple("N0$0"));
		bounds.boundExactly(x8, x8_upper);

		TupleSet x9_upper = factory.noneOf(1);
		x9_upper.add(factory.tuple("N1$0"));
		bounds.boundExactly(x9, x9_upper);

		TupleSet x10_upper = factory.noneOf(1);
		x10_upper.add(factory.tuple("N2$0"));
		bounds.boundExactly(x10, x10_upper);

		TupleSet x11_upper = factory.noneOf(1);
		bounds.boundExactly(x11, x11_upper);

		TupleSet x12_upper = factory.noneOf(1);
		x12_upper.add(factory.tuple("This$0"));
		bounds.boundExactly(x12, x12_upper);

		TupleSet x13_upper = factory.noneOf(1);
		bounds.boundExactly(x13, x13_upper);

		TupleSet x14_upper = factory.noneOf(1);
		x14_upper.add(factory.tuple("N2$0"));
		bounds.bound(x14, x14_upper);

		TupleSet x15_upper = factory.noneOf(1);
		x15_upper.add(factory.tuple("Null$0"));
		bounds.bound(x15, x15_upper);

		TupleSet x16_upper = factory.noneOf(1);
		x16_upper.add(factory.tuple("N1$0"));
		bounds.bound(x16, x16_upper);

		TupleSet x17_upper = factory.noneOf(1);
		x17_upper.add(factory.tuple("N2$0"));
		bounds.bound(x17, x17_upper);

		TupleSet x18_upper = factory.noneOf(1);
		x18_upper.add(factory.tuple("N0$0"));
		bounds.bound(x18, x18_upper);

		TupleSet x19_upper = factory.noneOf(1);
		x19_upper.add(factory.tuple("N1$0"));
		bounds.bound(x19, x19_upper);

		TupleSet x20_upper = factory.noneOf(2);
		x20_upper.add(factory.tuple("N0$0").product(factory.tuple("Null$0")));
		x20_upper.add(factory.tuple("N0$0").product(factory.tuple("Str$0")));
		x20_upper.add(factory.tuple("N0$0").product(factory.tuple("Str$1")));
		x20_upper.add(factory.tuple("N0$0").product(factory.tuple("Str$2")));
		x20_upper.add(factory.tuple("N1$0").product(factory.tuple("Null$0")));
		x20_upper.add(factory.tuple("N1$0").product(factory.tuple("Str$0")));
		x20_upper.add(factory.tuple("N1$0").product(factory.tuple("Str$1")));
		x20_upper.add(factory.tuple("N1$0").product(factory.tuple("Str$2")));
		x20_upper.add(factory.tuple("N2$0").product(factory.tuple("Null$0")));
		x20_upper.add(factory.tuple("N2$0").product(factory.tuple("Str$0")));
		x20_upper.add(factory.tuple("N2$0").product(factory.tuple("Str$1")));
		x20_upper.add(factory.tuple("N2$0").product(factory.tuple("Str$2")));
		bounds.bound(x20, x20_upper);

		TupleSet x21_upper = factory.noneOf(2);
		x21_upper.add(factory.tuple("N0$0").product(factory.tuple("N1$0")));
		x21_upper.add(factory.tuple("N1$0").product(factory.tuple("N2$0")));
		x21_upper.add(factory.tuple("N2$0").product(factory.tuple("Null$0")));
		bounds.bound(x21, x21_upper);

		TupleSet x22_upper = factory.noneOf(2);
		x22_upper.add(factory.tuple("N0$0").product(factory.tuple("N1$0")));
		x22_upper.add(factory.tuple("N0$0").product(factory.tuple("N2$0")));
		x22_upper.add(factory.tuple("N1$0").product(factory.tuple("N2$0")));
		x22_upper.add(factory.tuple("N2$0").product(factory.tuple("Null$0")));
		bounds.bound(x22, x22_upper);

		TupleSet x23_upper = factory.noneOf(2);
		x23_upper.add(factory.tuple("N0$0").product(factory.tuple("N1$0")));
		x23_upper.add(factory.tuple("N0$0").product(factory.tuple("N2$0")));
		x23_upper.add(factory.tuple("N1$0").product(factory.tuple("N0$0")));
		x23_upper.add(factory.tuple("N1$0").product(factory.tuple("N2$0")));
		x23_upper.add(factory.tuple("N2$0").product(factory.tuple("Null$0")));
		bounds.bound(x23, x23_upper);

		TupleSet x24_upper = factory.noneOf(2);
		x24_upper.add(factory.tuple("N0$0").product(factory.tuple("N1$0")));
		x24_upper.add(factory.tuple("N1$0").product(factory.tuple("N0$0")));
		x24_upper.add(factory.tuple("N1$0").product(factory.tuple("N2$0")));
		x24_upper.add(factory.tuple("N2$0").product(factory.tuple("Null$0")));
		x24_upper.add(factory.tuple("N2$0").product(factory.tuple("N1$0")));
		bounds.bound(x24, x24_upper);

		TupleSet x25_upper = factory.noneOf(2);
		x25_upper.add(factory.tuple("This$0").product(factory.tuple("N0$0")));
		bounds.bound(x25, x25_upper);

		TupleSet x26_upper = factory.noneOf(2);
		x26_upper.add(factory.tuple("This$0").product(factory.tuple("N0$0")));
		x26_upper.add(factory.tuple("This$0").product(factory.tuple("N1$0")));
		x26_upper.add(factory.tuple("This$0").product(factory.tuple("N2$0")));
		bounds.bound(x26, x26_upper);

		bounds.boundExactly(-8, factory.range(factory.tuple("-8"), factory.tuple("-8")));
		bounds.boundExactly(-7, factory.range(factory.tuple("-7"), factory.tuple("-7")));
		bounds.boundExactly(-6, factory.range(factory.tuple("-6"), factory.tuple("-6")));
		bounds.boundExactly(-5, factory.range(factory.tuple("-5"), factory.tuple("-5")));
		bounds.boundExactly(-4, factory.range(factory.tuple("-4"), factory.tuple("-4")));
		bounds.boundExactly(-3, factory.range(factory.tuple("-3"), factory.tuple("-3")));
		bounds.boundExactly(-2, factory.range(factory.tuple("-2"), factory.tuple("-2")));
		bounds.boundExactly(-1, factory.range(factory.tuple("-1"), factory.tuple("-1")));
		bounds.boundExactly(0, factory.range(factory.tuple("0"), factory.tuple("0")));
		bounds.boundExactly(1, factory.range(factory.tuple("1"), factory.tuple("1")));
		bounds.boundExactly(2, factory.range(factory.tuple("2"), factory.tuple("2")));
		bounds.boundExactly(3, factory.range(factory.tuple("3"), factory.tuple("3")));
		bounds.boundExactly(4, factory.range(factory.tuple("4"), factory.tuple("4")));
		bounds.boundExactly(5, factory.range(factory.tuple("5"), factory.tuple("5")));
		bounds.boundExactly(6, factory.range(factory.tuple("6"), factory.tuple("6")));
		bounds.boundExactly(7, factory.range(factory.tuple("7"), factory.tuple("7")));

		Expression x29 = x8.intersection(x9);
		Formula x28 = x29.no();
		Expression x32 = x8.union(x9);
		Expression x31 = x32.intersection(x10);
		Formula x30 = x31.no();
		Expression x36 = x32.union(x10);
		Expression x35 = x36.union(x11);
		Expression x34 = x35.union(x6);
		Formula x33 = x14.in(x34);
		Expression x38 = x35.union(x6);
		Formula x37 = x15.in(x38);
		Expression x40 = x35.union(x6);
		Formula x39 = x16.in(x40);
		Expression x42 = x35.union(x6);
		Formula x41 = x17.in(x42);
		Expression x44 = x35.union(x6);
		Formula x43 = x18.in(x44);
		Expression x46 = x35.union(x6);
		Formula x45 = x19.in(x46);
		Formula x47 = x14.one();
		Formula x48 = x15.one();
		Formula x49 = x16.one();
		Formula x50 = x17.one();
		Formula x51 = x18.one();
		Formula x52 = x19.one();
		Variable x55 = Variable.unary("this");
		Decls x54 = x55.oneOf(x35);
		Expression x58 = x55.join(x20);
		Formula x57 = x58.one();
		Expression x60 = x7.union(x6);
		Formula x59 = x58.in(x60);
		Formula x56 = x57.and(x59);
		Formula x53 = x56.forAll(x54);
		Expression x62 = x20.join(Expression.UNIV);
		Formula x61 = x62.in(x35);
		Variable x66 = Variable.unary("this");
		Decls x65 = x66.oneOf(x35);
		Expression x69 = x66.join(x21);
		Formula x68 = x69.one();
		Expression x71 = x35.union(x6);
		Formula x70 = x69.in(x71);
		Formula x67 = x68.and(x70);
		Formula x64 = x67.forAll(x65);
		Expression x73 = x21.join(Expression.UNIV);
		Formula x72 = x73.in(x35);
		Variable x76 = Variable.unary("this");
		Decls x75 = x76.oneOf(x35);
		Expression x79 = x76.join(x22);
		Formula x78 = x79.one();
		Expression x81 = x35.union(x6);
		Formula x80 = x79.in(x81);
		Formula x77 = x78.and(x80);
		Formula x74 = x77.forAll(x75);
		Expression x83 = x22.join(Expression.UNIV);
		Formula x82 = x83.in(x35);
		Variable x86 = Variable.unary("this");
		Decls x85 = x86.oneOf(x35);
		Expression x89 = x86.join(x23);
		Formula x88 = x89.one();
		Expression x91 = x35.union(x6);
		Formula x90 = x89.in(x91);
		Formula x87 = x88.and(x90);
		Formula x84 = x87.forAll(x85);
		Expression x93 = x23.join(Expression.UNIV);
		Formula x92 = x93.in(x35);
		Variable x96 = Variable.unary("this");
		Decls x95 = x96.oneOf(x35);
		Expression x99 = x96.join(x24);
		Formula x98 = x99.one();
		Expression x101 = x35.union(x6);
		Formula x100 = x99.in(x101);
		Formula x97 = x98.and(x100);
		Formula x94 = x97.forAll(x95);
		Expression x103 = x24.join(Expression.UNIV);
		Formula x102 = x103.in(x35);
		Variable x106 = Variable.unary("this");
		Expression x107 = x12.union(x13);
		Decls x105 = x106.oneOf(x107);
		Expression x110 = x106.join(x25);
		Formula x109 = x110.one();
		Expression x112 = x35.union(x6);
		Formula x111 = x110.in(x112);
		Formula x108 = x109.and(x111);
		Formula x104 = x108.forAll(x105);
		Expression x114 = x25.join(Expression.UNIV);
		Formula x113 = x114.in(x107);
		Variable x117 = Variable.unary("this");
		Decls x116 = x117.oneOf(x107);
		Expression x120 = x117.join(x26);
		Formula x119 = x120.one();
		Expression x122 = x35.union(x6);
		Formula x121 = x120.in(x122);
		Formula x118 = x119.and(x121);
		Formula x115 = x118.forAll(x116);
		Expression x124 = x26.join(Expression.UNIV);
		Formula x123 = x124.in(x107);
		Expression x126 = x12.product(x8);
		Formula x125 = x25.eq(x126);
		Expression x130 = x8.product(x9);
		Expression x131 = x9.product(x10);
		Expression x129 = x130.union(x131);
		Expression x132 = x10.product(x6);
		Expression x128 = x129.union(x132);
		Formula x127 = x21.eq(x128);
		Expression x134 = x12.join(x25);
		Formula x133 = x18.eq(x134);
		Expression x136 = x18.join(x21);
		Formula x135 = x16.eq(x136);
		Expression x138 = x16.join(x21);
		Formula x137 = x14.eq(x138);
		Expression x141 = x18.product(x14);
		Expression x140 = x21.override(x141);
		Formula x139 = x22.eq(x140);
		Expression x144 = x16.product(x18);
		Expression x143 = x22.override(x144);
		Formula x142 = x23.eq(x143);
		Formula x145 = x19.eq(x16);
		Formula x146 = x17.eq(x14);
		Expression x148 = x14.join(x23);
		Formula x147 = x15.eq(x148);
		Formula x153 = x14.eq(x6);
		Formula x152 = x153.not();
		Expression x151 = x152.thenElse(x23, x22);
		Expression x155 = x152.thenElse(x17, x16);
		Expression x156 = x152.thenElse(x19, x18);
		Expression x154 = x155.product(x156);
		Expression x150 = x151.override(x154);
		Formula x149 = x24.eq(x150);
		Expression x159 = x12.product(x155);
		Expression x158 = x25.override(x159);
		Formula x157 = x26.eq(x158);
		Expression x161 = x152.thenElse(x15, x14);
		Formula x160 = x161.eq(x6);
		Expression x164 = x21.closure();
		Expression x172 = Expression.INTS.union(x5);
		Expression x171 = x172.union(x6);
		Expression x170 = x171.union(x7);
		Expression x169 = x170.union(x35);
		Expression x168 = x169.union(x107);
		Expression x167 = x168.product(Expression.UNIV);
		Expression x165 = Expression.IDEN.intersection(x167);
		Expression x163 = x164.intersection(x165);
		Formula x162 = x163.no();
		Expression x177 = x12.join(x25);
		Formula x176 = x177.eq(x6);
		Formula x175 = x176.not();
		Expression x181 = x12.join(x25);
		Expression x180 = x181.join(x21);
		Formula x179 = x180.eq(x6);
		Formula x178 = x179.not();
		Formula x174 = x175.and(x178);
		Expression x184 = x24.closure();
		Expression x186 = x168.product(Expression.UNIV);
		Expression x185 = Expression.IDEN.intersection(x186);
		Expression x183 = x184.intersection(x185);
		Formula x182 = x183.no();
		Expression x190 = x12.join(x26);
		Expression x192 = x24.closure();
		Expression x194 = x168.product(Expression.UNIV);
		Expression x193 = Expression.IDEN.intersection(x194);
		Expression x191 = x192.union(x193);
		Expression x189 = x190.join(x191);
		Expression x196 = x12.join(x25);
		Expression x198 = x21.closure();
		Expression x200 = x168.product(Expression.UNIV);
		Expression x199 = Expression.IDEN.intersection(x200);
		Expression x197 = x198.union(x199);
		Expression x195 = x196.join(x197);
		Formula x188 = x189.eq(x195);
		Expression x209 = x12.join(x25);
		Expression x211 = x21.closure();
		Expression x213 = x168.product(Expression.UNIV);
		Expression x212 = Expression.IDEN.intersection(x213);
		Expression x210 = x211.union(x212);
		Expression x208 = x209.join(x210);
		Expression x207 = x208.difference(x6);
		Expression x206 = x207.product(x207);
		Expression x205 = x21.intersection(x206);
		Expression x204 = x205.transpose();
		Expression x203 = x21.override(x204);
		Expression x215 = x12.join(x25);
		Expression x214 = x215.product(x6);
		Expression x202 = x203.override(x214);
		Formula x201 = x24.eq(x202);
		Formula x187 = x188.and(x201);
		Formula x216 = x0.eq(x0);
		Formula x217 = x1.eq(x1);
		Formula x218 = x2.eq(x2);
		Formula x219 = x3.eq(x3);
		Formula x220 = x4.eq(x4);
		Formula x221 = x5.eq(x5);
		Formula x222 = x6.eq(x6);
		Formula x223 = x7.eq(x7);
		Formula x224 = x8.eq(x8);
		Formula x225 = x9.eq(x9);
		Formula x226 = x10.eq(x10);
		Formula x227 = x11.eq(x11);
		Formula x228 = x12.eq(x12);
		Formula x229 = x13.eq(x13);
		Formula x230 = x14.eq(x14);
		Formula x231 = x15.eq(x15);
		Formula x232 = x16.eq(x16);
		Formula x233 = x17.eq(x17);
		Formula x234 = x18.eq(x18);
		Formula x235 = x19.eq(x19);
		Formula x236 = x20.eq(x20);
		Formula x237 = x21.eq(x21);
		Formula x238 = x22.eq(x22);
		Formula x239 = x23.eq(x23);
		Formula x240 = x24.eq(x24);
		Formula x241 = x25.eq(x25);
		Formula x242 = x26.eq(x26);
		Formula x27 = Formula.compose(FormulaOperator.AND, x28, x30, x33, x37, x39, x41, x43, x45, x47, x48, x49, x50,
				x51, x52, x53, x61, x64, x72, x74, x82, x84, x92, x94, x102, x104, x113, x115, x123, x125, x127, x133,
				x135, x137, x139, x142, x145, x146, x147, x149, x157, x160, x162, x174, x182, x187, x216, x217, x218,
				x219, x220, x221, x222, x223, x224, x225, x226, x227, x228, x229, x230, x231, x232, x233, x234, x235,
				x236, x237, x238, x239, x240, x241, x242);

		Solver solver = new Solver();
		solver.options().setSolver(SATFactory.DefaultSAT4J);
		solver.options().setBitwidth(4);
		// solver.options().setFlatten(false);
		solver.options().setIntEncoding(Options.IntEncoding.TWOSCOMPLEMENT);
		solver.options().setSymmetryBreaking(20);
		solver.options().setSkolemDepth(0);
		System.out.println("Solving...");
		System.out.flush();
		System.out.println(bounds);
		Solution sol = solver.solve(x27, bounds);
		System.out.println(sol.toString());
	}
}
