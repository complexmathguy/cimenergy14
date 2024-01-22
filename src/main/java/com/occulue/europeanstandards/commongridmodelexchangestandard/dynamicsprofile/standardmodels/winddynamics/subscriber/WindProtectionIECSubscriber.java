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
 * Subscriber for WindProtectionIEC related events. .
 *
 * @author your_name_here
 */
@Component("windProtectionIEC-subscriber")
public class WindProtectionIECSubscriber extends BaseSubscriber {

  public WindProtectionIECSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<WindProtectionIEC>, WindProtectionIEC>
      windProtectionIECSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllWindProtectionIECQuery(),
        ResponseTypes.multipleInstancesOf(WindProtectionIEC.class),
        ResponseTypes.instanceOf(WindProtectionIEC.class));
  }

  public SubscriptionQueryResult<WindProtectionIEC, WindProtectionIEC> windProtectionIECSubscribe(
      @DestinationVariable UUID windProtectionIECId) {
    return queryGateway.subscriptionQuery(
        new FindWindProtectionIECQuery(new LoadWindProtectionIECFilter(windProtectionIECId)),
        ResponseTypes.instanceOf(WindProtectionIEC.class),
        ResponseTypes.instanceOf(WindProtectionIEC.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
