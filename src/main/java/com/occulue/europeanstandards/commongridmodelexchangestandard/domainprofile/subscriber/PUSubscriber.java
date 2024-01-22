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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.subscriber;

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
 * Subscriber for PU related events. .
 *
 * @author your_name_here
 */
@Component("pU-subscriber")
public class PUSubscriber extends BaseSubscriber {

  public PUSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<PU>, PU> pUSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllPUQuery(),
        ResponseTypes.multipleInstancesOf(PU.class),
        ResponseTypes.instanceOf(PU.class));
  }

  public SubscriptionQueryResult<PU, PU> pUSubscribe(@DestinationVariable UUID pUId) {
    return queryGateway.subscriptionQuery(
        new FindPUQuery(new LoadPUFilter(pUId)),
        ResponseTypes.instanceOf(PU.class),
        ResponseTypes.instanceOf(PU.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
