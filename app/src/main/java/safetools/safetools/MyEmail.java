package safetools.safetools;
import android.support.v4.app.*;
import android.os.*;
import android.view.*;
import android.support.v7.widget.*;

public class MyEmail extends Fragment implements View.OnClickListener
{

	private Communicator comm;

	private CardView b1;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		// TODO: Implement this method
		return inflater.inflate(R.layout.email,null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onActivityCreated(savedInstanceState);
		comm=(Communicator) getActivity();

		b1=(CardView) getActivity().findViewById(R.id.card_view6);
		b1.setOnClickListener(this);
	}
	@Override
	public void onClick(View p1)
	{
		// TODO: Implement this method
		if(p1.getId()==R.id.card_view6){
			comm.respond("S2");
		}
		}
	
}
