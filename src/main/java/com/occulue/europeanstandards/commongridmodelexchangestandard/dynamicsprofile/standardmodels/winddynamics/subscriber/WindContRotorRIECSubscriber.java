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
 * Subscriber for WindContRotorRIEC related events. .
 *
 * @author your_name_here
 */
@Component("windContRotorRIEC-subscriber")
public class WindContRotorRIECSubscriber extends BaseSubscriber {

  public WindContRotorRIECSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<WindContRotorRIEC>, WindContRotorRIEC>
      windContRotorRIECSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllWindContRotorRIECQuery(),
        ResponseTypes.multipleInstancesOf(WindContRotorRIEC.class),
        ResponseTypes.instanceOf(WindContRotorRIEC.class));
  }

  public SubscriptionQueryResult<WindContRotorRIEC, WindContRotorRIEC> windContRotorRIECSubscribe(
      @DestinationVariable UUID windContRotorRIECId) {
    return queryGateway.subscriptionQuery(
        new FindWindContRotorRIECQuery(new LoadWindContRotorRIECFilter(windContRotorRIECId)),
        ResponseTypes.instanceOf(WindContRotorRIEC.class),
        ResponseTypes.instanceOf(WindContRotorRIEC.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
