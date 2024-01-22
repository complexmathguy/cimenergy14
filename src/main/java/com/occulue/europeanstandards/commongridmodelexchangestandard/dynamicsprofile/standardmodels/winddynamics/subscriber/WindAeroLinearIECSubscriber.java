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
 * Subscriber for WindAeroLinearIEC related events. .
 *
 * @author your_name_here
 */
@Component("windAeroLinearIEC-subscriber")
public class WindAeroLinearIECSubscriber extends BaseSubscriber {

  public WindAeroLinearIECSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<WindAeroLinearIEC>, WindAeroLinearIEC>
      windAeroLinearIECSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllWindAeroLinearIECQuery(),
        ResponseTypes.multipleInstancesOf(WindAeroLinearIEC.class),
        ResponseTypes.instanceOf(WindAeroLinearIEC.class));
  }

  public SubscriptionQueryResult<WindAeroLinearIEC, WindAeroLinearIEC> windAeroLinearIECSubscribe(
      @DestinationVariable UUID windAeroLinearIECId) {
    return queryGateway.subscriptionQuery(
        new FindWindAeroLinearIECQuery(new LoadWindAeroLinearIECFilter(windAeroLinearIECId)),
        ResponseTypes.instanceOf(WindAeroLinearIEC.class),
        ResponseTypes.instanceOf(WindAeroLinearIEC.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
