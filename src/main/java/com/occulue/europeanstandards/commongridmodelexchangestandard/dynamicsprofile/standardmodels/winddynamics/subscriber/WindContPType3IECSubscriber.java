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
 * Subscriber for WindContPType3IEC related events. .
 *
 * @author your_name_here
 */
@Component("windContPType3IEC-subscriber")
public class WindContPType3IECSubscriber extends BaseSubscriber {

  public WindContPType3IECSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<WindContPType3IEC>, WindContPType3IEC>
      windContPType3IECSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllWindContPType3IECQuery(),
        ResponseTypes.multipleInstancesOf(WindContPType3IEC.class),
        ResponseTypes.instanceOf(WindContPType3IEC.class));
  }

  public SubscriptionQueryResult<WindContPType3IEC, WindContPType3IEC> windContPType3IECSubscribe(
      @DestinationVariable UUID windContPType3IECId) {
    return queryGateway.subscriptionQuery(
        new FindWindContPType3IECQuery(new LoadWindContPType3IECFilter(windContPType3IECId)),
        ResponseTypes.instanceOf(WindContPType3IEC.class),
        ResponseTypes.instanceOf(WindContPType3IEC.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
