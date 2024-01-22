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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.subscriber;

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
 * Subscriber for Substation related events. .
 *
 * @author your_name_here
 */
@Component("substation-subscriber")
public class SubstationSubscriber extends BaseSubscriber {

  public SubstationSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<Substation>, Substation> substationSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllSubstationQuery(),
        ResponseTypes.multipleInstancesOf(Substation.class),
        ResponseTypes.instanceOf(Substation.class));
  }

  public SubscriptionQueryResult<Substation, Substation> substationSubscribe(
      @DestinationVariable UUID substationId) {
    return queryGateway.subscriptionQuery(
        new FindSubstationQuery(new LoadSubstationFilter(substationId)),
        ResponseTypes.instanceOf(Substation.class),
        ResponseTypes.instanceOf(Substation.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
