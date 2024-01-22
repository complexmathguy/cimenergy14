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
 * Subscriber for WindGenType4IEC related events. .
 *
 * @author your_name_here
 */
@Component("windGenType4IEC-subscriber")
public class WindGenType4IECSubscriber extends BaseSubscriber {

  public WindGenType4IECSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<WindGenType4IEC>, WindGenType4IEC>
      windGenType4IECSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllWindGenType4IECQuery(),
        ResponseTypes.multipleInstancesOf(WindGenType4IEC.class),
        ResponseTypes.instanceOf(WindGenType4IEC.class));
  }

  public SubscriptionQueryResult<WindGenType4IEC, WindGenType4IEC> windGenType4IECSubscribe(
      @DestinationVariable UUID windGenType4IECId) {
    return queryGateway.subscriptionQuery(
        new FindWindGenType4IECQuery(new LoadWindGenType4IECFilter(windGenType4IECId)),
        ResponseTypes.instanceOf(WindGenType4IEC.class),
        ResponseTypes.instanceOf(WindGenType4IEC.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
