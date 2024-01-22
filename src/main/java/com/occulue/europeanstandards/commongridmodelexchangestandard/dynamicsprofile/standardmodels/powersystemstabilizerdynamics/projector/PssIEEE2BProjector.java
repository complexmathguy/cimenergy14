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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for PssIEEE2B as outlined for the CQRS pattern. All event handling and query handling
 * related to PssIEEE2B are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by PssIEEE2BAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("pssIEEE2B")
@Component("pssIEEE2B-projector")
public class PssIEEE2BProjector extends PssIEEE2BEntityProjector {

  // core constructor
  public PssIEEE2BProjector(PssIEEE2BRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreatePssIEEE2BEvent
   */
  @EventHandler(payloadType = CreatePssIEEE2BEvent.class)
  public void handle(CreatePssIEEE2BEvent event) {
    LOGGER.info("handling CreatePssIEEE2BEvent - " + event);
    PssIEEE2B entity = new PssIEEE2B();
    entity.setPssIEEE2BId(event.getPssIEEE2BId());
    entity.setInputSignal1Type(event.getInputSignal1Type());
    entity.setInputSignal2Type(event.getInputSignal2Type());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event UpdatePssIEEE2BEvent
   */
  @EventHandler(payloadType = UpdatePssIEEE2BEvent.class)
  public void handle(UpdatePssIEEE2BEvent event) {
    LOGGER.info("handling UpdatePssIEEE2BEvent - " + event);

    PssIEEE2B entity = new PssIEEE2B();
    entity.setPssIEEE2BId(event.getPssIEEE2BId());
    entity.setInputSignal1Type(event.getInputSignal1Type());
    entity.setInputSignal2Type(event.getInputSignal2Type());
    entity.setKs1(event.getKs1());
    entity.setKs2(event.getKs2());
    entity.setKs3(event.getKs3());
    entity.setM(event.getM());
    entity.setN(event.getN());
    entity.setT1(event.getT1());
    entity.setT10(event.getT10());
    entity.setT11(event.getT11());
    entity.setT2(event.getT2());
    entity.setT3(event.getT3());
    entity.setT4(event.getT4());
    entity.setT6(event.getT6());
    entity.setT7(event.getT7());
    entity.setT8(event.getT8());
    entity.setT9(event.getT9());
    entity.setTw1(event.getTw1());
    entity.setTw2(event.getTw2());
    entity.setTw3(event.getTw3());
    entity.setTw4(event.getTw4());
    entity.setVsi1max(event.getVsi1max());
    entity.setVsi1min(event.getVsi1min());
    entity.setVsi2max(event.getVsi2max());
    entity.setVsi2min(event.getVsi2min());
    entity.setVstmax(event.getVstmax());
    entity.setVstmin(event.getVstmin());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event DeletePssIEEE2BEvent
   */
  @EventHandler(payloadType = DeletePssIEEE2BEvent.class)
  public void handle(DeletePssIEEE2BEvent event) {
    LOGGER.info("handling DeletePssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    PssIEEE2B entity = delete(event.getPssIEEE2BId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event AssignKs1ToPssIEEE2BEvent
   */
  @EventHandler(payloadType = AssignKs1ToPssIEEE2BEvent.class)
  public void handle(AssignKs1ToPssIEEE2BEvent event) {
    LOGGER.info("handling AssignKs1ToPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE2B entity = assignKs1(event.getPssIEEE2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event UnAssignKs1FromPssIEEE2BEvent
   */
  @EventHandler(payloadType = UnAssignKs1FromPssIEEE2BEvent.class)
  public void handle(UnAssignKs1FromPssIEEE2BEvent event) {
    LOGGER.info("handling UnAssignKs1FromPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE2B entity = unAssignKs1(event.getPssIEEE2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event AssignKs2ToPssIEEE2BEvent
   */
  @EventHandler(payloadType = AssignKs2ToPssIEEE2BEvent.class)
  public void handle(AssignKs2ToPssIEEE2BEvent event) {
    LOGGER.info("handling AssignKs2ToPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE2B entity = assignKs2(event.getPssIEEE2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event UnAssignKs2FromPssIEEE2BEvent
   */
  @EventHandler(payloadType = UnAssignKs2FromPssIEEE2BEvent.class)
  public void handle(UnAssignKs2FromPssIEEE2BEvent event) {
    LOGGER.info("handling UnAssignKs2FromPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE2B entity = unAssignKs2(event.getPssIEEE2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event AssignKs3ToPssIEEE2BEvent
   */
  @EventHandler(payloadType = AssignKs3ToPssIEEE2BEvent.class)
  public void handle(AssignKs3ToPssIEEE2BEvent event) {
    LOGGER.info("handling AssignKs3ToPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE2B entity = assignKs3(event.getPssIEEE2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event UnAssignKs3FromPssIEEE2BEvent
   */
  @EventHandler(payloadType = UnAssignKs3FromPssIEEE2BEvent.class)
  public void handle(UnAssignKs3FromPssIEEE2BEvent event) {
    LOGGER.info("handling UnAssignKs3FromPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE2B entity = unAssignKs3(event.getPssIEEE2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event AssignMToPssIEEE2BEvent
   */
  @EventHandler(payloadType = AssignMToPssIEEE2BEvent.class)
  public void handle(AssignMToPssIEEE2BEvent event) {
    LOGGER.info("handling AssignMToPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE2B entity = assignM(event.getPssIEEE2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event UnAssignMFromPssIEEE2BEvent
   */
  @EventHandler(payloadType = UnAssignMFromPssIEEE2BEvent.class)
  public void handle(UnAssignMFromPssIEEE2BEvent event) {
    LOGGER.info("handling UnAssignMFromPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE2B entity = unAssignM(event.getPssIEEE2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event AssignNToPssIEEE2BEvent
   */
  @EventHandler(payloadType = AssignNToPssIEEE2BEvent.class)
  public void handle(AssignNToPssIEEE2BEvent event) {
    LOGGER.info("handling AssignNToPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE2B entity = assignN(event.getPssIEEE2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event UnAssignNFromPssIEEE2BEvent
   */
  @EventHandler(payloadType = UnAssignNFromPssIEEE2BEvent.class)
  public void handle(UnAssignNFromPssIEEE2BEvent event) {
    LOGGER.info("handling UnAssignNFromPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE2B entity = unAssignN(event.getPssIEEE2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event AssignT1ToPssIEEE2BEvent
   */
  @EventHandler(payloadType = AssignT1ToPssIEEE2BEvent.class)
  public void handle(AssignT1ToPssIEEE2BEvent event) {
    LOGGER.info("handling AssignT1ToPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE2B entity = assignT1(event.getPssIEEE2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event UnAssignT1FromPssIEEE2BEvent
   */
  @EventHandler(payloadType = UnAssignT1FromPssIEEE2BEvent.class)
  public void handle(UnAssignT1FromPssIEEE2BEvent event) {
    LOGGER.info("handling UnAssignT1FromPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE2B entity = unAssignT1(event.getPssIEEE2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event AssignT10ToPssIEEE2BEvent
   */
  @EventHandler(payloadType = AssignT10ToPssIEEE2BEvent.class)
  public void handle(AssignT10ToPssIEEE2BEvent event) {
    LOGGER.info("handling AssignT10ToPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE2B entity = assignT10(event.getPssIEEE2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event UnAssignT10FromPssIEEE2BEvent
   */
  @EventHandler(payloadType = UnAssignT10FromPssIEEE2BEvent.class)
  public void handle(UnAssignT10FromPssIEEE2BEvent event) {
    LOGGER.info("handling UnAssignT10FromPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE2B entity = unAssignT10(event.getPssIEEE2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event AssignT11ToPssIEEE2BEvent
   */
  @EventHandler(payloadType = AssignT11ToPssIEEE2BEvent.class)
  public void handle(AssignT11ToPssIEEE2BEvent event) {
    LOGGER.info("handling AssignT11ToPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE2B entity = assignT11(event.getPssIEEE2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event UnAssignT11FromPssIEEE2BEvent
   */
  @EventHandler(payloadType = UnAssignT11FromPssIEEE2BEvent.class)
  public void handle(UnAssignT11FromPssIEEE2BEvent event) {
    LOGGER.info("handling UnAssignT11FromPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE2B entity = unAssignT11(event.getPssIEEE2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event AssignT2ToPssIEEE2BEvent
   */
  @EventHandler(payloadType = AssignT2ToPssIEEE2BEvent.class)
  public void handle(AssignT2ToPssIEEE2BEvent event) {
    LOGGER.info("handling AssignT2ToPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE2B entity = assignT2(event.getPssIEEE2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event UnAssignT2FromPssIEEE2BEvent
   */
  @EventHandler(payloadType = UnAssignT2FromPssIEEE2BEvent.class)
  public void handle(UnAssignT2FromPssIEEE2BEvent event) {
    LOGGER.info("handling UnAssignT2FromPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE2B entity = unAssignT2(event.getPssIEEE2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event AssignT3ToPssIEEE2BEvent
   */
  @EventHandler(payloadType = AssignT3ToPssIEEE2BEvent.class)
  public void handle(AssignT3ToPssIEEE2BEvent event) {
    LOGGER.info("handling AssignT3ToPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE2B entity = assignT3(event.getPssIEEE2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event UnAssignT3FromPssIEEE2BEvent
   */
  @EventHandler(payloadType = UnAssignT3FromPssIEEE2BEvent.class)
  public void handle(UnAssignT3FromPssIEEE2BEvent event) {
    LOGGER.info("handling UnAssignT3FromPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE2B entity = unAssignT3(event.getPssIEEE2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event AssignT4ToPssIEEE2BEvent
   */
  @EventHandler(payloadType = AssignT4ToPssIEEE2BEvent.class)
  public void handle(AssignT4ToPssIEEE2BEvent event) {
    LOGGER.info("handling AssignT4ToPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE2B entity = assignT4(event.getPssIEEE2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event UnAssignT4FromPssIEEE2BEvent
   */
  @EventHandler(payloadType = UnAssignT4FromPssIEEE2BEvent.class)
  public void handle(UnAssignT4FromPssIEEE2BEvent event) {
    LOGGER.info("handling UnAssignT4FromPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE2B entity = unAssignT4(event.getPssIEEE2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event AssignT6ToPssIEEE2BEvent
   */
  @EventHandler(payloadType = AssignT6ToPssIEEE2BEvent.class)
  public void handle(AssignT6ToPssIEEE2BEvent event) {
    LOGGER.info("handling AssignT6ToPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE2B entity = assignT6(event.getPssIEEE2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event UnAssignT6FromPssIEEE2BEvent
   */
  @EventHandler(payloadType = UnAssignT6FromPssIEEE2BEvent.class)
  public void handle(UnAssignT6FromPssIEEE2BEvent event) {
    LOGGER.info("handling UnAssignT6FromPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE2B entity = unAssignT6(event.getPssIEEE2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event AssignT7ToPssIEEE2BEvent
   */
  @EventHandler(payloadType = AssignT7ToPssIEEE2BEvent.class)
  public void handle(AssignT7ToPssIEEE2BEvent event) {
    LOGGER.info("handling AssignT7ToPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE2B entity = assignT7(event.getPssIEEE2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event UnAssignT7FromPssIEEE2BEvent
   */
  @EventHandler(payloadType = UnAssignT7FromPssIEEE2BEvent.class)
  public void handle(UnAssignT7FromPssIEEE2BEvent event) {
    LOGGER.info("handling UnAssignT7FromPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE2B entity = unAssignT7(event.getPssIEEE2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event AssignT8ToPssIEEE2BEvent
   */
  @EventHandler(payloadType = AssignT8ToPssIEEE2BEvent.class)
  public void handle(AssignT8ToPssIEEE2BEvent event) {
    LOGGER.info("handling AssignT8ToPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE2B entity = assignT8(event.getPssIEEE2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event UnAssignT8FromPssIEEE2BEvent
   */
  @EventHandler(payloadType = UnAssignT8FromPssIEEE2BEvent.class)
  public void handle(UnAssignT8FromPssIEEE2BEvent event) {
    LOGGER.info("handling UnAssignT8FromPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE2B entity = unAssignT8(event.getPssIEEE2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event AssignT9ToPssIEEE2BEvent
   */
  @EventHandler(payloadType = AssignT9ToPssIEEE2BEvent.class)
  public void handle(AssignT9ToPssIEEE2BEvent event) {
    LOGGER.info("handling AssignT9ToPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE2B entity = assignT9(event.getPssIEEE2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event UnAssignT9FromPssIEEE2BEvent
   */
  @EventHandler(payloadType = UnAssignT9FromPssIEEE2BEvent.class)
  public void handle(UnAssignT9FromPssIEEE2BEvent event) {
    LOGGER.info("handling UnAssignT9FromPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE2B entity = unAssignT9(event.getPssIEEE2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event AssignTw1ToPssIEEE2BEvent
   */
  @EventHandler(payloadType = AssignTw1ToPssIEEE2BEvent.class)
  public void handle(AssignTw1ToPssIEEE2BEvent event) {
    LOGGER.info("handling AssignTw1ToPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE2B entity = assignTw1(event.getPssIEEE2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event UnAssignTw1FromPssIEEE2BEvent
   */
  @EventHandler(payloadType = UnAssignTw1FromPssIEEE2BEvent.class)
  public void handle(UnAssignTw1FromPssIEEE2BEvent event) {
    LOGGER.info("handling UnAssignTw1FromPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE2B entity = unAssignTw1(event.getPssIEEE2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event AssignTw2ToPssIEEE2BEvent
   */
  @EventHandler(payloadType = AssignTw2ToPssIEEE2BEvent.class)
  public void handle(AssignTw2ToPssIEEE2BEvent event) {
    LOGGER.info("handling AssignTw2ToPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE2B entity = assignTw2(event.getPssIEEE2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event UnAssignTw2FromPssIEEE2BEvent
   */
  @EventHandler(payloadType = UnAssignTw2FromPssIEEE2BEvent.class)
  public void handle(UnAssignTw2FromPssIEEE2BEvent event) {
    LOGGER.info("handling UnAssignTw2FromPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE2B entity = unAssignTw2(event.getPssIEEE2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event AssignTw3ToPssIEEE2BEvent
   */
  @EventHandler(payloadType = AssignTw3ToPssIEEE2BEvent.class)
  public void handle(AssignTw3ToPssIEEE2BEvent event) {
    LOGGER.info("handling AssignTw3ToPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE2B entity = assignTw3(event.getPssIEEE2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event UnAssignTw3FromPssIEEE2BEvent
   */
  @EventHandler(payloadType = UnAssignTw3FromPssIEEE2BEvent.class)
  public void handle(UnAssignTw3FromPssIEEE2BEvent event) {
    LOGGER.info("handling UnAssignTw3FromPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE2B entity = unAssignTw3(event.getPssIEEE2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event AssignTw4ToPssIEEE2BEvent
   */
  @EventHandler(payloadType = AssignTw4ToPssIEEE2BEvent.class)
  public void handle(AssignTw4ToPssIEEE2BEvent event) {
    LOGGER.info("handling AssignTw4ToPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE2B entity = assignTw4(event.getPssIEEE2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event UnAssignTw4FromPssIEEE2BEvent
   */
  @EventHandler(payloadType = UnAssignTw4FromPssIEEE2BEvent.class)
  public void handle(UnAssignTw4FromPssIEEE2BEvent event) {
    LOGGER.info("handling UnAssignTw4FromPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE2B entity = unAssignTw4(event.getPssIEEE2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event AssignVsi1maxToPssIEEE2BEvent
   */
  @EventHandler(payloadType = AssignVsi1maxToPssIEEE2BEvent.class)
  public void handle(AssignVsi1maxToPssIEEE2BEvent event) {
    LOGGER.info("handling AssignVsi1maxToPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE2B entity = assignVsi1max(event.getPssIEEE2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event UnAssignVsi1maxFromPssIEEE2BEvent
   */
  @EventHandler(payloadType = UnAssignVsi1maxFromPssIEEE2BEvent.class)
  public void handle(UnAssignVsi1maxFromPssIEEE2BEvent event) {
    LOGGER.info("handling UnAssignVsi1maxFromPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE2B entity = unAssignVsi1max(event.getPssIEEE2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event AssignVsi1minToPssIEEE2BEvent
   */
  @EventHandler(payloadType = AssignVsi1minToPssIEEE2BEvent.class)
  public void handle(AssignVsi1minToPssIEEE2BEvent event) {
    LOGGER.info("handling AssignVsi1minToPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE2B entity = assignVsi1min(event.getPssIEEE2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event UnAssignVsi1minFromPssIEEE2BEvent
   */
  @EventHandler(payloadType = UnAssignVsi1minFromPssIEEE2BEvent.class)
  public void handle(UnAssignVsi1minFromPssIEEE2BEvent event) {
    LOGGER.info("handling UnAssignVsi1minFromPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE2B entity = unAssignVsi1min(event.getPssIEEE2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event AssignVsi2maxToPssIEEE2BEvent
   */
  @EventHandler(payloadType = AssignVsi2maxToPssIEEE2BEvent.class)
  public void handle(AssignVsi2maxToPssIEEE2BEvent event) {
    LOGGER.info("handling AssignVsi2maxToPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE2B entity = assignVsi2max(event.getPssIEEE2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event UnAssignVsi2maxFromPssIEEE2BEvent
   */
  @EventHandler(payloadType = UnAssignVsi2maxFromPssIEEE2BEvent.class)
  public void handle(UnAssignVsi2maxFromPssIEEE2BEvent event) {
    LOGGER.info("handling UnAssignVsi2maxFromPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE2B entity = unAssignVsi2max(event.getPssIEEE2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event AssignVsi2minToPssIEEE2BEvent
   */
  @EventHandler(payloadType = AssignVsi2minToPssIEEE2BEvent.class)
  public void handle(AssignVsi2minToPssIEEE2BEvent event) {
    LOGGER.info("handling AssignVsi2minToPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE2B entity = assignVsi2min(event.getPssIEEE2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event UnAssignVsi2minFromPssIEEE2BEvent
   */
  @EventHandler(payloadType = UnAssignVsi2minFromPssIEEE2BEvent.class)
  public void handle(UnAssignVsi2minFromPssIEEE2BEvent event) {
    LOGGER.info("handling UnAssignVsi2minFromPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE2B entity = unAssignVsi2min(event.getPssIEEE2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event AssignVstmaxToPssIEEE2BEvent
   */
  @EventHandler(payloadType = AssignVstmaxToPssIEEE2BEvent.class)
  public void handle(AssignVstmaxToPssIEEE2BEvent event) {
    LOGGER.info("handling AssignVstmaxToPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE2B entity = assignVstmax(event.getPssIEEE2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event UnAssignVstmaxFromPssIEEE2BEvent
   */
  @EventHandler(payloadType = UnAssignVstmaxFromPssIEEE2BEvent.class)
  public void handle(UnAssignVstmaxFromPssIEEE2BEvent event) {
    LOGGER.info("handling UnAssignVstmaxFromPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE2B entity = unAssignVstmax(event.getPssIEEE2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event AssignVstminToPssIEEE2BEvent
   */
  @EventHandler(payloadType = AssignVstminToPssIEEE2BEvent.class)
  public void handle(AssignVstminToPssIEEE2BEvent event) {
    LOGGER.info("handling AssignVstminToPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE2B entity = assignVstmin(event.getPssIEEE2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /*
   * @param	event UnAssignVstminFromPssIEEE2BEvent
   */
  @EventHandler(payloadType = UnAssignVstminFromPssIEEE2BEvent.class)
  public void handle(UnAssignVstminFromPssIEEE2BEvent event) {
    LOGGER.info("handling UnAssignVstminFromPssIEEE2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE2B entity = unAssignVstmin(event.getPssIEEE2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE2B(entity);
  }

  /**
   * Method to retrieve the PssIEEE2B via an PssIEEE2BPrimaryKey.
   *
   * @param id Long
   * @return PssIEEE2B
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public PssIEEE2B handle(FindPssIEEE2BQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getPssIEEE2BId());
  }

  /**
   * Method to retrieve a collection of all PssIEEE2Bs
   *
   * @param query FindAllPssIEEE2BQuery
   * @return List<PssIEEE2B>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<PssIEEE2B> handle(FindAllPssIEEE2BQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindPssIEEE2B, but only if the id matches
   *
   * @param entity PssIEEE2B
   */
  protected void emitFindPssIEEE2B(PssIEEE2B entity) {
    LOGGER.info("handling emitFindPssIEEE2B");

    queryUpdateEmitter.emit(
        FindPssIEEE2BQuery.class,
        query -> query.getFilter().getPssIEEE2BId().equals(entity.getPssIEEE2BId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllPssIEEE2B
   *
   * @param entity PssIEEE2B
   */
  protected void emitFindAllPssIEEE2B(PssIEEE2B entity) {
    LOGGER.info("handling emitFindAllPssIEEE2B");

    queryUpdateEmitter.emit(FindAllPssIEEE2BQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(PssIEEE2BProjector.class.getName());
}
