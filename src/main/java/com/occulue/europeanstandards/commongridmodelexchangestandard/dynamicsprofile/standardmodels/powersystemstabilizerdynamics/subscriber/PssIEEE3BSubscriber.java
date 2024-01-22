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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.subscriber;

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
 * Subscriber for PssIEEE3B related events. .
 *
 * @author your_name_here
 */
@Component("pssIEEE3B-subscriber")
public class PssIEEE3BSubscriber extends BaseSubscriber {

  public PssIEEE3BSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<PssIEEE3B>, PssIEEE3B> pssIEEE3BSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllPssIEEE3BQuery(),
        ResponseTypes.multipleInstancesOf(PssIEEE3B.class),
        ResponseTypes.instanceOf(PssIEEE3B.class));
  }

  public SubscriptionQueryResult<PssIEEE3B, PssIEEE3B> pssIEEE3BSubscribe(
      @DestinationVariable UUID pssIEEE3BId) {
    return queryGateway.subscriptionQuery(
        new FindPssIEEE3BQuery(new LoadPssIEEE3BFilter(pssIEEE3BId)),
        ResponseTypes.instanceOf(PssIEEE3B.class),
        ResponseTypes.instanceOf(PssIEEE3B.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
