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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.subscriber;

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
 * Subscriber for PhaseTapChangerTabular related events. .
 *
 * @author your_name_here
 */
@Component("phaseTapChangerTabular-subscriber")
public class PhaseTapChangerTabularSubscriber extends BaseSubscriber {

  public PhaseTapChangerTabularSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<PhaseTapChangerTabular>, PhaseTapChangerTabular>
      phaseTapChangerTabularSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllPhaseTapChangerTabularQuery(),
        ResponseTypes.multipleInstancesOf(PhaseTapChangerTabular.class),
        ResponseTypes.instanceOf(PhaseTapChangerTabular.class));
  }

  public SubscriptionQueryResult<PhaseTapChangerTabular, PhaseTapChangerTabular>
      phaseTapChangerTabularSubscribe(@DestinationVariable UUID phaseTapChangerTabularId) {
    return queryGateway.subscriptionQuery(
        new FindPhaseTapChangerTabularQuery(
            new LoadPhaseTapChangerTabularFilter(phaseTapChangerTabularId)),
        ResponseTypes.instanceOf(PhaseTapChangerTabular.class),
        ResponseTypes.instanceOf(PhaseTapChangerTabular.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
