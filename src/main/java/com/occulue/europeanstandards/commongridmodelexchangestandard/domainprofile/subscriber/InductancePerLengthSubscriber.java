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
 * Subscriber for InductancePerLength related events. .
 *
 * @author your_name_here
 */
@Component("inductancePerLength-subscriber")
public class InductancePerLengthSubscriber extends BaseSubscriber {

  public InductancePerLengthSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<InductancePerLength>, InductancePerLength>
      inductancePerLengthSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllInductancePerLengthQuery(),
        ResponseTypes.multipleInstancesOf(InductancePerLength.class),
        ResponseTypes.instanceOf(InductancePerLength.class));
  }

  public SubscriptionQueryResult<InductancePerLength, InductancePerLength>
      inductancePerLengthSubscribe(@DestinationVariable UUID inductancePerLengthId) {
    return queryGateway.subscriptionQuery(
        new FindInductancePerLengthQuery(new LoadInductancePerLengthFilter(inductancePerLengthId)),
        ResponseTypes.instanceOf(InductancePerLength.class),
        ResponseTypes.instanceOf(InductancePerLength.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
