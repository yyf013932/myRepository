package basestructure;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class AVLTree<T extends Comparable<T>> {
	
	private static final int WIDTH = 1024, HEIGHT = 768;
	private int currentX, currentY, maxY, size_x, size_y;
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
			BufferedImage.TYPE_INT_RGB);
	private static final Font font=new Font("",Font.PLAIN,20);
	TreeNode<T> root;

	public AVLTree() {
		root = null;
	}

	public void insert(T element) {
		root = insert_(root, element);
	}

	private TreeNode<T> insert_(TreeNode<T> node, T element) {
		if (node == null)
			return new TreeNode<T>(element);
		int result = node.value.compareTo(element);
		if (result < 0) {
			node.right = insert_(node.right, element);
			if ((height(node.right) - height(node.left)) == 2) {
				if (height(node.right.right) > height(node.right.left))
					node = rotateWithRightChild(node);
				else
					node = doubleWithRightChild(node);
			}
		} else if (result > 0) {
			node.left = insert_(node.left, element);
			if ((height(node.right) - height(node.left)) == -2) {
				if (height(node.left.right) < height(node.left.left))
					node = rotateWithLeftChild(node);
				else
					node = doubleWithLeftChild(node);
			}
		} else
			node.mark++;
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		return node;
	}

	private int height(TreeNode<T> node) {
		return node == null ? -1 : node.height;
	}

	private TreeNode<T> rotateWithLeftChild(TreeNode<T> node) {
		TreeNode<T> n1 = node.left;
		node.left = n1.right;
		n1.right = node;
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		n1.height = Math.max(height(n1.left), height(n1.right)) + 1;
		return n1;

	}

	private TreeNode<T> doubleWithLeftChild(TreeNode<T> node) {
		node.left = rotateWithRightChild(node.left);
		return rotateWithLeftChild(node);

	}

	private TreeNode<T> rotateWithRightChild(TreeNode<T> node) {
		TreeNode<T> n1 = node.right;
		node.right = n1.left;
		n1.left = node;
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		n1.height = Math.max(height(n1.left), height(n1.right)) + 1;
		return n1;
	}

	private TreeNode<T> doubleWithRightChild(TreeNode<T> node) {
		node.right = rotateWithLeftChild(node.right);
		return rotateWithRightChild(node);
	}

	public boolean remove(T element) {
		return remove_(root, element);
	}

	private boolean remove_(TreeNode<T> node, T element) {
		return false;
	}

	/**
	 * clear the tree
	 * @param node
	 * @return 
	 */
	public boolean clear(TreeNode<T> node) {
		if (node.left != null)
			clear(node.left);
		if (node.right != null)
			clear(node.right);
		node = null;
		return true;
	}

	/**
	 * calculate if the element is in the tree
	 * @param node
	 * @param element
	 * @return if element is in the tree,return true,else return false
	 */
	public boolean contains(T element) {
		return contains_(root, element);
	}

	/**
	 * the actual method called by contains
	 * @param node
	 * @param element
	 * @return
	 */
	private boolean contains_(TreeNode<T> node, T element) {
		int result = node.value.compareTo(element);
		if (result > 0 && node.left != null)
			return contains_(node.left, element);
		else if (result < 0 && node.right != null)
			return contains_(node.right, element);
		else if (result == 0 && node.mark != 0)
			return true;
		else
			return false;
	}

	// the node of the tree
	private static class TreeNode<T> {
		public T value;
		public TreeNode<T> left;
		public TreeNode<T> right;
		public int height;
		public int x, y;
		// mark the occured times of the value in the tree
		public int mark;

		public TreeNode(T value) {
			this(value, null, null);
		}

		public TreeNode(T value, TreeNode<T> left, TreeNode<T> right) {
			this.value = value;
			this.left = left;
			this.right = right;
			height = 0;
			mark = 1;
		}
	}

	// get the image of the tree
	// use it draw a tree
	public BufferedImage getTreeImage() {
		return image;
	}

	public void creatTreeImage() {
		Graphics g = image.getGraphics();
		currentX = 0;
		currentY = 0;
		getX_Y(root);
		max_Y(root);
		size_x = WIDTH / (currentX + 5);
		size_y = HEIGHT / (maxY + 6);
		System.out.println(currentX + " " + size_x + "\n" + maxY + "  "
				+ size_y);
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.black);
		drawImage(g, root);
	}

	private void drawImage(Graphics g, TreeNode<T> node) {

		if (node.left != null) {
			g.drawLine((node.x + 2) * size_x, (node.y + 2) * size_y,
					(node.left.x + 2) * size_x, (node.left.y + 2) * size_y);
			drawImage(g, node.left);
		}
		if (node.right != null) {
			g.drawLine((node.x + 2) * size_x, (node.y + 2) * size_y,
					(node.right.x + 2) * size_x, (node.right.y + 2) * size_y);
			drawImage(g, node.right);
		}
		g.setColor(Color.white);
		g.fillOval((node.x + 2) * size_x - (3 * size_x + size_y) / 12,
				(node.y + 2) * size_y - (3 * size_x + size_y) / 12,
				(3 * size_x + size_y) / 6, (3 * size_x + size_y) / 6);
		g.setColor(Color.black);
		g.drawOval((node.x + 2) * size_x - (3 * size_x + size_y) / 12,
				(node.y + 2) * size_y - (3 * size_x + size_y) / 12,
				(3 * size_x + size_y) / 6, (3 * size_x + size_y) / 6);
		// g.setFont(new Font("", Font.PLAIN, 20));
		g.drawString(node.value.toString(),
				(node.x + 2) * size_x - size_x / 10, (node.y + 2) * size_y+size_x/10);
	}

	private void getX_Y(TreeNode<T> node) {
		if (node.left != null) {
			currentY++;
			getX_Y(node.left);
			currentY--;
		}
		node.x = currentX++;
		node.y = currentY;
		if (node.right != null) {
			currentY++;
			getX_Y(node.right);
			currentY--;
		}
	}

	private void max_Y(TreeNode<T> node) {
		if (node.y > maxY)
			maxY = node.y;
		if (node.left != null)
			max_Y(node.left);
		if (node.right != null)
			max_Y(node.right);
	}

	private ArrayList<TreeNode<T>> treeValue() {
		ArrayList<TreeNode<T>> values = new ArrayList<TreeNode<T>>();
		values.add(root);
		int i, j;
		i = 0;
		j = 1;
		while (i < values.size()) {
			if (values.get(i).left != null)
				values.add(values.get(i).left);
			if (values.get(i).right != null)
				values.add(values.get(i).right);
			i++;
		}

		return values;
	}

	public void printTree() {
		for (TreeNode<T> node : treeValue()) {
			System.out.print(node.value + " ");
		}
	}
}
