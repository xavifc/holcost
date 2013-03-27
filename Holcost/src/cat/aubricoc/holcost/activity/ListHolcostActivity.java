package cat.aubricoc.holcost.activity;

import java.util.List;

import org.holoeverywhere.app.Activity;
import org.holoeverywhere.widget.ListView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import cat.aubricoc.holcost.R;
import cat.aubricoc.holcost.model.Holcost;
import cat.aubricoc.holcost.service.HolcostService;

import com.actionbarsherlock.view.MenuItem;



public class ListHolcostActivity extends Activity {

	private HolcostService holcostService = new HolcostService(this);

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.list_holcost);
		
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		final List<Holcost> holcosts = holcostService.getAllHolcosts();
		
		ListView listView = (ListView) findViewById(R.id.listHolcost);

		listView.setAdapter(new ArrayAdapter<Holcost>(this, R.layout.list_line,
				holcosts));
		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {

				Holcost holcost = holcosts.get(position);
				holcostService.openHolcost(holcost);
				
				setResult(RESULT_OK);
				
				Intent intent = new Intent(ListHolcostActivity.this,
						HolcostActivity.class);
				startActivity(intent);
				
				finish();
			}
		});
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

        case android.R.id.home:
             finish();
             break;

        default:
            return super.onOptionsItemSelected(item);
        }
        return false;
    }
}