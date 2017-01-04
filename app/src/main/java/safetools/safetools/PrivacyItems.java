package safetools.safetools;
import android.os.*;
import android.support.v4.app.*;
import android.support.v7.widget.CardView;
import android.view.*;


public class PrivacyItems extends Fragment implements View.OnClickListener
{
	
CardView b1,b3,b2,b4;
 Communicator comm;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		// TODO: Implement this method
		return inflater.inflate(R.layout.orbot,null);
	}



	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onActivityCreated(savedInstanceState);

		comm=(Communicator) getActivity();

		b1=(CardView) getActivity().findViewById(R.id.card_view1);
		b2=(CardView) getActivity().findViewById(R.id.card_view2);
		b3=(CardView) getActivity().findViewById(R.id.card_view3);
		b4=(CardView) getActivity().findViewById(R.id.card_view4);
		
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);
		
	}





	@Override
	public void onClick(View p1)
	{
		// TODO: Implement this method
		if(p1.getId()==R.id.card_view1){
			comm.respond("a1");
		}else if(p1.getId()==R.id.card_view2){
			comm.respond("A2");
		}else if(p1.getId()==R.id.card_view3){
			comm.respond("A3");
		}else if(p1.getId()==R.id.card_view4){
			comm.respond("A4");
		}
		
		
	}
	
	
}
