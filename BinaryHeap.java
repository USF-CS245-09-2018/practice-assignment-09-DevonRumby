import java.util.NoSuchElementException;

public class BinaryHeap {
	int[] binaryHeap;
	int heapSize;

	public BinaryHeap() {
		binaryHeap = new int[10];
		heapSize = 0;
	}

	public void add(int i) {
		int child = heapSize;
		if (heapSize == binaryHeap.length) {
			increaseSize();
		}
		binaryHeap[heapSize++] = i;
		int tmp = binaryHeap[child];
		while (child > 0 && tmp < binaryHeap[(child - 1) / 2]) {
			binaryHeap[child] = binaryHeap[(child - 1) / 2];
			child = (child - 1) / 2;
		}
		binaryHeap[child] = tmp;
	}

	public int remove() {
		int child = 0;
		int temp = 0;
		int tmp = binaryHeap[0];
		if (heapSize == 0) {
			throw new NoSuchElementException("Underflow Exception");
		}
		int keyItem = binaryHeap[child];
		binaryHeap[child] = binaryHeap[heapSize - 1];
		heapSize--;

		while (2 * temp + 1 < heapSize) {
			child = minChild(temp);
			if (binaryHeap[child] < tmp)
				binaryHeap[temp] = binaryHeap[child];
			else
				break;
			temp = child;
		}
		binaryHeap[temp] = tmp;
		return keyItem;
	}

	private int minChild(int i) {
		int child = 2 * i + 1;
		int k = 2;
		int pos = 2 * i + 1;
		while ((k <= 2) && (pos < heapSize)) {
			if (binaryHeap[pos] < binaryHeap[child]) {
				child = pos;
			}
			pos = 2 * i + k++;
		}
		return child;
	}

	public void increaseSize() {
		int[] temp = new int[binaryHeap.length * 2];
		for (int i = 0; i < binaryHeap.length; i++) {
			temp[i] = binaryHeap[i];
		}
		binaryHeap = temp;
	}
}