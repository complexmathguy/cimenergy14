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
 * Subscriber for PssIEEE1A related events. .
 *
 * @author your_name_here
 */
@Component("pssIEEE1A-subscriber")
public class PssIEEE1ASubscriber extends BaseSubscriber {

  public PssIEEE1ASubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<PssIEEE1A>, PssIEEE1A> pssIEEE1ASubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllPssIEEE1AQuery(),
        ResponseTypes.multipleInstancesOf(PssIEEE1A.class),
        ResponseTypes.instanceOf(PssIEEE1A.class));
  }

  public SubscriptionQueryResult<PssIEEE1A, PssIEEE1A> pssIEEE1ASubscribe(
      @DestinationVariable UUID pssIEEE1AId) {
    return queryGateway.subscriptionQuery(
        new FindPssIEEE1AQuery(new LoadPssIEEE1AFilter(pssIEEE1AId)),
        ResponseTypes.instanceOf(PssIEEE1A.class),
        ResponseTypes.instanceOf(PssIEEE1A.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
