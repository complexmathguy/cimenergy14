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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.subscriber;

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
 * Subscriber for ExcSK related events. .
 *
 * @author your_name_here
 */
@Component("excSK-subscriber")
public class ExcSKSubscriber extends BaseSubscriber {

  public ExcSKSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ExcSK>, ExcSK> excSKSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllExcSKQuery(),
        ResponseTypes.multipleInstancesOf(ExcSK.class),
        ResponseTypes.instanceOf(ExcSK.class));
  }

  public SubscriptionQueryResult<ExcSK, ExcSK> excSKSubscribe(@DestinationVariable UUID excSKId) {
    return queryGateway.subscriptionQuery(
        new FindExcSKQuery(new LoadExcSKFilter(excSKId)),
        ResponseTypes.instanceOf(ExcSK.class),
        ResponseTypes.instanceOf(ExcSK.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
