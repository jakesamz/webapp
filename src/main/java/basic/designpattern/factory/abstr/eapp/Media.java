package basic.designpattern.factory.abstr.eapp;

public class Media implements EAppFactory {

	@Override
	public AC createAC() {
		// TODO Auto-generated method stub
		return new MediaAC();
	}

	@Override
	public Refrigerator createRefrigerator() {
		// TODO Auto-generated method stub
		return new Mediafriger();
	}

}
