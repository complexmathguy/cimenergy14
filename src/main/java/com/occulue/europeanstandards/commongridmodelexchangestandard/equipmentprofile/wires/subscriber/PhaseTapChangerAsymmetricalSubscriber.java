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
 * Subscriber for PhaseTapChangerAsymmetrical related events. .
 *
 * @author your_name_here
 */
@Component("phaseTapChangerAsymmetrical-subscriber")
public class PhaseTapChangerAsymmetricalSubscriber extends BaseSubscriber {

  public PhaseTapChangerAsymmetricalSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<PhaseTapChangerAsymmetrical>, PhaseTapChangerAsymmetrical>
      phaseTapChangerAsymmetricalSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllPhaseTapChangerAsymmetricalQuery(),
        ResponseTypes.multipleInstancesOf(PhaseTapChangerAsymmetrical.class),
        ResponseTypes.instanceOf(PhaseTapChangerAsymmetrical.class));
  }

  public SubscriptionQueryResult<PhaseTapChangerAsymmetrical, PhaseTapChangerAsymmetrical>
      phaseTapChangerAsymmetricalSubscribe(
          @DestinationVariable UUID phaseTapChangerAsymmetricalId) {
    return queryGateway.subscriptionQuery(
        new FindPhaseTapChangerAsymmetricalQuery(
            new LoadPhaseTapChangerAsymmetricalFilter(phaseTapChangerAsymmetricalId)),
        ResponseTypes.instanceOf(PhaseTapChangerAsymmetrical.class),
        ResponseTypes.instanceOf(PhaseTapChangerAsymmetrical.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
