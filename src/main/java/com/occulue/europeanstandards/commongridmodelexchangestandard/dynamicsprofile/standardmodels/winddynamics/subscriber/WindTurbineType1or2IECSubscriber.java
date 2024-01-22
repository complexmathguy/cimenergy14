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
 * Subscriber for WindTurbineType1or2IEC related events. .
 *
 * @author your_name_here
 */
@Component("windTurbineType1or2IEC-subscriber")
public class WindTurbineType1or2IECSubscriber extends BaseSubscriber {

  public WindTurbineType1or2IECSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<WindTurbineType1or2IEC>, WindTurbineType1or2IEC>
      windTurbineType1or2IECSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllWindTurbineType1or2IECQuery(),
        ResponseTypes.multipleInstancesOf(WindTurbineType1or2IEC.class),
        ResponseTypes.instanceOf(WindTurbineType1or2IEC.class));
  }

  public SubscriptionQueryResult<WindTurbineType1or2IEC, WindTurbineType1or2IEC>
      windTurbineType1or2IECSubscribe(@DestinationVariable UUID windTurbineType1or2IECId) {
    return queryGateway.subscriptionQuery(
        new FindWindTurbineType1or2IECQuery(
            new LoadWindTurbineType1or2IECFilter(windTurbineType1or2IECId)),
        ResponseTypes.instanceOf(WindTurbineType1or2IEC.class),
        ResponseTypes.instanceOf(WindTurbineType1or2IEC.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
