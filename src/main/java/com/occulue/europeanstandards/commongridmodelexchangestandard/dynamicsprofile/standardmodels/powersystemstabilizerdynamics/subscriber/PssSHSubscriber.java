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
 * Subscriber for PssSH related events. .
 *
 * @author your_name_here
 */
@Component("pssSH-subscriber")
public class PssSHSubscriber extends BaseSubscriber {

  public PssSHSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<PssSH>, PssSH> pssSHSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllPssSHQuery(),
        ResponseTypes.multipleInstancesOf(PssSH.class),
        ResponseTypes.instanceOf(PssSH.class));
  }

  public SubscriptionQueryResult<PssSH, PssSH> pssSHSubscribe(@DestinationVariable UUID pssSHId) {
    return queryGateway.subscriptionQuery(
        new FindPssSHQuery(new LoadPssSHFilter(pssSHId)),
        ResponseTypes.instanceOf(PssSH.class),
        ResponseTypes.instanceOf(PssSH.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
