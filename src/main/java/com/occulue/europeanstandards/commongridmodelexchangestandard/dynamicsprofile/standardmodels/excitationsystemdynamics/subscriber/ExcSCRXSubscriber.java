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
 * Subscriber for ExcSCRX related events. .
 *
 * @author your_name_here
 */
@Component("excSCRX-subscriber")
public class ExcSCRXSubscriber extends BaseSubscriber {

  public ExcSCRXSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ExcSCRX>, ExcSCRX> excSCRXSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllExcSCRXQuery(),
        ResponseTypes.multipleInstancesOf(ExcSCRX.class),
        ResponseTypes.instanceOf(ExcSCRX.class));
  }

  public SubscriptionQueryResult<ExcSCRX, ExcSCRX> excSCRXSubscribe(
      @DestinationVariable UUID excSCRXId) {
    return queryGateway.subscriptionQuery(
        new FindExcSCRXQuery(new LoadExcSCRXFilter(excSCRXId)),
        ResponseTypes.instanceOf(ExcSCRX.class),
        ResponseTypes.instanceOf(ExcSCRX.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
