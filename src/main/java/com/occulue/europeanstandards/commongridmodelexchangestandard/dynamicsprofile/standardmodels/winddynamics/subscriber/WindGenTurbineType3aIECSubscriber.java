/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.subscriber;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import com.occulue.subscriber.*;
import java.util.*;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.SubscriptionQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.stereotype.Component;

/**
 * Subscriber for WindGenTurbineType3aIEC related events. .
 *
 * @author your_name_here
 */
@Component("windGenTurbineType3aIEC-subscriber")
public class WindGenTurbineType3aIECSubscriber extends BaseSubscriber {

  public WindGenTurbineType3aIECSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<WindGenTurbineType3aIEC>, WindGenTurbineType3aIEC>
      windGenTurbineType3aIECSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllWindGenTurbineType3aIECQuery(),
        ResponseTypes.multipleInstancesOf(WindGenTurbineType3aIEC.class),
        ResponseTypes.instanceOf(WindGenTurbineType3aIEC.class));
  }

  public SubscriptionQueryResult<WindGenTurbineType3aIEC, WindGenTurbineType3aIEC>
      windGenTurbineType3aIECSubscribe(@DestinationVariable UUID windGenTurbineType3aIECId) {
    return queryGateway.subscriptionQuery(
        new FindWindGenTurbineType3aIECQuery(
            new LoadWindGenTurbineType3aIECFilter(windGenTurbineType3aIECId)),
        ResponseTypes.instanceOf(WindGenTurbineType3aIEC.class),
        ResponseTypes.instanceOf(WindGenTurbineType3aIEC.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
