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
 * Projector for Pss2B as outlined for the CQRS pattern. All event handling and query handling
 * related to Pss2B are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by Pss2BAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("pss2B")
@Component("pss2B-projector")
public class Pss2BProjector extends Pss2BEntityProjector {

  // core constructor
  public Pss2BProjector(Pss2BRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreatePss2BEvent
   */
  @EventHandler(payloadType = CreatePss2BEvent.class)
  public void handle(CreatePss2BEvent event) {
    LOGGER.info("handling CreatePss2BEvent - " + event);
    Pss2B entity = new Pss2B();
    entity.setPss2BId(event.getPss2BId());
    entity.setInputSignal1Type(event.getInputSignal1Type());
    entity.setInputSignal2Type(event.getInputSignal2Type());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event UpdatePss2BEvent
   */
  @EventHandler(payloadType = UpdatePss2BEvent.class)
  public void handle(UpdatePss2BEvent event) {
    LOGGER.info("handling UpdatePss2BEvent - " + event);

    Pss2B entity = new Pss2B();
    entity.setPss2BId(event.getPss2BId());
    entity.setA(event.getA());
    entity.setInputSignal1Type(event.getInputSignal1Type());
    entity.setInputSignal2Type(event.getInputSignal2Type());
    entity.setKs1(event.getKs1());
    entity.setKs2(event.getKs2());
    entity.setKs3(event.getKs3());
    entity.setKs4(event.getKs4());
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
    entity.setTa(event.getTa());
    entity.setTb(event.getTb());
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
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event DeletePss2BEvent
   */
  @EventHandler(payloadType = DeletePss2BEvent.class)
  public void handle(DeletePss2BEvent event) {
    LOGGER.info("handling DeletePss2BEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    Pss2B entity = delete(event.getPss2BId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event AssignAToPss2BEvent
   */
  @EventHandler(payloadType = AssignAToPss2BEvent.class)
  public void handle(AssignAToPss2BEvent event) {
    LOGGER.info("handling AssignAToPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2B entity = assignA(event.getPss2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event UnAssignAFromPss2BEvent
   */
  @EventHandler(payloadType = UnAssignAFromPss2BEvent.class)
  public void handle(UnAssignAFromPss2BEvent event) {
    LOGGER.info("handling UnAssignAFromPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2B entity = unAssignA(event.getPss2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event AssignKs1ToPss2BEvent
   */
  @EventHandler(payloadType = AssignKs1ToPss2BEvent.class)
  public void handle(AssignKs1ToPss2BEvent event) {
    LOGGER.info("handling AssignKs1ToPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2B entity = assignKs1(event.getPss2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event UnAssignKs1FromPss2BEvent
   */
  @EventHandler(payloadType = UnAssignKs1FromPss2BEvent.class)
  public void handle(UnAssignKs1FromPss2BEvent event) {
    LOGGER.info("handling UnAssignKs1FromPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2B entity = unAssignKs1(event.getPss2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event AssignKs2ToPss2BEvent
   */
  @EventHandler(payloadType = AssignKs2ToPss2BEvent.class)
  public void handle(AssignKs2ToPss2BEvent event) {
    LOGGER.info("handling AssignKs2ToPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2B entity = assignKs2(event.getPss2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event UnAssignKs2FromPss2BEvent
   */
  @EventHandler(payloadType = UnAssignKs2FromPss2BEvent.class)
  public void handle(UnAssignKs2FromPss2BEvent event) {
    LOGGER.info("handling UnAssignKs2FromPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2B entity = unAssignKs2(event.getPss2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event AssignKs3ToPss2BEvent
   */
  @EventHandler(payloadType = AssignKs3ToPss2BEvent.class)
  public void handle(AssignKs3ToPss2BEvent event) {
    LOGGER.info("handling AssignKs3ToPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2B entity = assignKs3(event.getPss2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event UnAssignKs3FromPss2BEvent
   */
  @EventHandler(payloadType = UnAssignKs3FromPss2BEvent.class)
  public void handle(UnAssignKs3FromPss2BEvent event) {
    LOGGER.info("handling UnAssignKs3FromPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2B entity = unAssignKs3(event.getPss2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event AssignKs4ToPss2BEvent
   */
  @EventHandler(payloadType = AssignKs4ToPss2BEvent.class)
  public void handle(AssignKs4ToPss2BEvent event) {
    LOGGER.info("handling AssignKs4ToPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2B entity = assignKs4(event.getPss2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event UnAssignKs4FromPss2BEvent
   */
  @EventHandler(payloadType = UnAssignKs4FromPss2BEvent.class)
  public void handle(UnAssignKs4FromPss2BEvent event) {
    LOGGER.info("handling UnAssignKs4FromPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2B entity = unAssignKs4(event.getPss2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event AssignMToPss2BEvent
   */
  @EventHandler(payloadType = AssignMToPss2BEvent.class)
  public void handle(AssignMToPss2BEvent event) {
    LOGGER.info("handling AssignMToPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2B entity = assignM(event.getPss2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event UnAssignMFromPss2BEvent
   */
  @EventHandler(payloadType = UnAssignMFromPss2BEvent.class)
  public void handle(UnAssignMFromPss2BEvent event) {
    LOGGER.info("handling UnAssignMFromPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2B entity = unAssignM(event.getPss2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event AssignNToPss2BEvent
   */
  @EventHandler(payloadType = AssignNToPss2BEvent.class)
  public void handle(AssignNToPss2BEvent event) {
    LOGGER.info("handling AssignNToPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2B entity = assignN(event.getPss2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event UnAssignNFromPss2BEvent
   */
  @EventHandler(payloadType = UnAssignNFromPss2BEvent.class)
  public void handle(UnAssignNFromPss2BEvent event) {
    LOGGER.info("handling UnAssignNFromPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2B entity = unAssignN(event.getPss2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event AssignT1ToPss2BEvent
   */
  @EventHandler(payloadType = AssignT1ToPss2BEvent.class)
  public void handle(AssignT1ToPss2BEvent event) {
    LOGGER.info("handling AssignT1ToPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2B entity = assignT1(event.getPss2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event UnAssignT1FromPss2BEvent
   */
  @EventHandler(payloadType = UnAssignT1FromPss2BEvent.class)
  public void handle(UnAssignT1FromPss2BEvent event) {
    LOGGER.info("handling UnAssignT1FromPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2B entity = unAssignT1(event.getPss2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event AssignT10ToPss2BEvent
   */
  @EventHandler(payloadType = AssignT10ToPss2BEvent.class)
  public void handle(AssignT10ToPss2BEvent event) {
    LOGGER.info("handling AssignT10ToPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2B entity = assignT10(event.getPss2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event UnAssignT10FromPss2BEvent
   */
  @EventHandler(payloadType = UnAssignT10FromPss2BEvent.class)
  public void handle(UnAssignT10FromPss2BEvent event) {
    LOGGER.info("handling UnAssignT10FromPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2B entity = unAssignT10(event.getPss2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event AssignT11ToPss2BEvent
   */
  @EventHandler(payloadType = AssignT11ToPss2BEvent.class)
  public void handle(AssignT11ToPss2BEvent event) {
    LOGGER.info("handling AssignT11ToPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2B entity = assignT11(event.getPss2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event UnAssignT11FromPss2BEvent
   */
  @EventHandler(payloadType = UnAssignT11FromPss2BEvent.class)
  public void handle(UnAssignT11FromPss2BEvent event) {
    LOGGER.info("handling UnAssignT11FromPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2B entity = unAssignT11(event.getPss2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event AssignT2ToPss2BEvent
   */
  @EventHandler(payloadType = AssignT2ToPss2BEvent.class)
  public void handle(AssignT2ToPss2BEvent event) {
    LOGGER.info("handling AssignT2ToPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2B entity = assignT2(event.getPss2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event UnAssignT2FromPss2BEvent
   */
  @EventHandler(payloadType = UnAssignT2FromPss2BEvent.class)
  public void handle(UnAssignT2FromPss2BEvent event) {
    LOGGER.info("handling UnAssignT2FromPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2B entity = unAssignT2(event.getPss2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event AssignT3ToPss2BEvent
   */
  @EventHandler(payloadType = AssignT3ToPss2BEvent.class)
  public void handle(AssignT3ToPss2BEvent event) {
    LOGGER.info("handling AssignT3ToPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2B entity = assignT3(event.getPss2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event UnAssignT3FromPss2BEvent
   */
  @EventHandler(payloadType = UnAssignT3FromPss2BEvent.class)
  public void handle(UnAssignT3FromPss2BEvent event) {
    LOGGER.info("handling UnAssignT3FromPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2B entity = unAssignT3(event.getPss2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event AssignT4ToPss2BEvent
   */
  @EventHandler(payloadType = AssignT4ToPss2BEvent.class)
  public void handle(AssignT4ToPss2BEvent event) {
    LOGGER.info("handling AssignT4ToPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2B entity = assignT4(event.getPss2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event UnAssignT4FromPss2BEvent
   */
  @EventHandler(payloadType = UnAssignT4FromPss2BEvent.class)
  public void handle(UnAssignT4FromPss2BEvent event) {
    LOGGER.info("handling UnAssignT4FromPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2B entity = unAssignT4(event.getPss2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event AssignT6ToPss2BEvent
   */
  @EventHandler(payloadType = AssignT6ToPss2BEvent.class)
  public void handle(AssignT6ToPss2BEvent event) {
    LOGGER.info("handling AssignT6ToPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2B entity = assignT6(event.getPss2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event UnAssignT6FromPss2BEvent
   */
  @EventHandler(payloadType = UnAssignT6FromPss2BEvent.class)
  public void handle(UnAssignT6FromPss2BEvent event) {
    LOGGER.info("handling UnAssignT6FromPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2B entity = unAssignT6(event.getPss2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event AssignT7ToPss2BEvent
   */
  @EventHandler(payloadType = AssignT7ToPss2BEvent.class)
  public void handle(AssignT7ToPss2BEvent event) {
    LOGGER.info("handling AssignT7ToPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2B entity = assignT7(event.getPss2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event UnAssignT7FromPss2BEvent
   */
  @EventHandler(payloadType = UnAssignT7FromPss2BEvent.class)
  public void handle(UnAssignT7FromPss2BEvent event) {
    LOGGER.info("handling UnAssignT7FromPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2B entity = unAssignT7(event.getPss2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event AssignT8ToPss2BEvent
   */
  @EventHandler(payloadType = AssignT8ToPss2BEvent.class)
  public void handle(AssignT8ToPss2BEvent event) {
    LOGGER.info("handling AssignT8ToPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2B entity = assignT8(event.getPss2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event UnAssignT8FromPss2BEvent
   */
  @EventHandler(payloadType = UnAssignT8FromPss2BEvent.class)
  public void handle(UnAssignT8FromPss2BEvent event) {
    LOGGER.info("handling UnAssignT8FromPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2B entity = unAssignT8(event.getPss2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event AssignT9ToPss2BEvent
   */
  @EventHandler(payloadType = AssignT9ToPss2BEvent.class)
  public void handle(AssignT9ToPss2BEvent event) {
    LOGGER.info("handling AssignT9ToPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2B entity = assignT9(event.getPss2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event UnAssignT9FromPss2BEvent
   */
  @EventHandler(payloadType = UnAssignT9FromPss2BEvent.class)
  public void handle(UnAssignT9FromPss2BEvent event) {
    LOGGER.info("handling UnAssignT9FromPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2B entity = unAssignT9(event.getPss2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event AssignTaToPss2BEvent
   */
  @EventHandler(payloadType = AssignTaToPss2BEvent.class)
  public void handle(AssignTaToPss2BEvent event) {
    LOGGER.info("handling AssignTaToPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2B entity = assignTa(event.getPss2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event UnAssignTaFromPss2BEvent
   */
  @EventHandler(payloadType = UnAssignTaFromPss2BEvent.class)
  public void handle(UnAssignTaFromPss2BEvent event) {
    LOGGER.info("handling UnAssignTaFromPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2B entity = unAssignTa(event.getPss2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event AssignTbToPss2BEvent
   */
  @EventHandler(payloadType = AssignTbToPss2BEvent.class)
  public void handle(AssignTbToPss2BEvent event) {
    LOGGER.info("handling AssignTbToPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2B entity = assignTb(event.getPss2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event UnAssignTbFromPss2BEvent
   */
  @EventHandler(payloadType = UnAssignTbFromPss2BEvent.class)
  public void handle(UnAssignTbFromPss2BEvent event) {
    LOGGER.info("handling UnAssignTbFromPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2B entity = unAssignTb(event.getPss2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event AssignTw1ToPss2BEvent
   */
  @EventHandler(payloadType = AssignTw1ToPss2BEvent.class)
  public void handle(AssignTw1ToPss2BEvent event) {
    LOGGER.info("handling AssignTw1ToPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2B entity = assignTw1(event.getPss2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event UnAssignTw1FromPss2BEvent
   */
  @EventHandler(payloadType = UnAssignTw1FromPss2BEvent.class)
  public void handle(UnAssignTw1FromPss2BEvent event) {
    LOGGER.info("handling UnAssignTw1FromPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2B entity = unAssignTw1(event.getPss2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event AssignTw2ToPss2BEvent
   */
  @EventHandler(payloadType = AssignTw2ToPss2BEvent.class)
  public void handle(AssignTw2ToPss2BEvent event) {
    LOGGER.info("handling AssignTw2ToPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2B entity = assignTw2(event.getPss2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event UnAssignTw2FromPss2BEvent
   */
  @EventHandler(payloadType = UnAssignTw2FromPss2BEvent.class)
  public void handle(UnAssignTw2FromPss2BEvent event) {
    LOGGER.info("handling UnAssignTw2FromPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2B entity = unAssignTw2(event.getPss2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event AssignTw3ToPss2BEvent
   */
  @EventHandler(payloadType = AssignTw3ToPss2BEvent.class)
  public void handle(AssignTw3ToPss2BEvent event) {
    LOGGER.info("handling AssignTw3ToPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2B entity = assignTw3(event.getPss2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event UnAssignTw3FromPss2BEvent
   */
  @EventHandler(payloadType = UnAssignTw3FromPss2BEvent.class)
  public void handle(UnAssignTw3FromPss2BEvent event) {
    LOGGER.info("handling UnAssignTw3FromPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2B entity = unAssignTw3(event.getPss2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event AssignTw4ToPss2BEvent
   */
  @EventHandler(payloadType = AssignTw4ToPss2BEvent.class)
  public void handle(AssignTw4ToPss2BEvent event) {
    LOGGER.info("handling AssignTw4ToPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2B entity = assignTw4(event.getPss2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event UnAssignTw4FromPss2BEvent
   */
  @EventHandler(payloadType = UnAssignTw4FromPss2BEvent.class)
  public void handle(UnAssignTw4FromPss2BEvent event) {
    LOGGER.info("handling UnAssignTw4FromPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2B entity = unAssignTw4(event.getPss2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event AssignVsi1maxToPss2BEvent
   */
  @EventHandler(payloadType = AssignVsi1maxToPss2BEvent.class)
  public void handle(AssignVsi1maxToPss2BEvent event) {
    LOGGER.info("handling AssignVsi1maxToPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2B entity = assignVsi1max(event.getPss2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event UnAssignVsi1maxFromPss2BEvent
   */
  @EventHandler(payloadType = UnAssignVsi1maxFromPss2BEvent.class)
  public void handle(UnAssignVsi1maxFromPss2BEvent event) {
    LOGGER.info("handling UnAssignVsi1maxFromPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2B entity = unAssignVsi1max(event.getPss2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event AssignVsi1minToPss2BEvent
   */
  @EventHandler(payloadType = AssignVsi1minToPss2BEvent.class)
  public void handle(AssignVsi1minToPss2BEvent event) {
    LOGGER.info("handling AssignVsi1minToPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2B entity = assignVsi1min(event.getPss2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event UnAssignVsi1minFromPss2BEvent
   */
  @EventHandler(payloadType = UnAssignVsi1minFromPss2BEvent.class)
  public void handle(UnAssignVsi1minFromPss2BEvent event) {
    LOGGER.info("handling UnAssignVsi1minFromPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2B entity = unAssignVsi1min(event.getPss2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event AssignVsi2maxToPss2BEvent
   */
  @EventHandler(payloadType = AssignVsi2maxToPss2BEvent.class)
  public void handle(AssignVsi2maxToPss2BEvent event) {
    LOGGER.info("handling AssignVsi2maxToPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2B entity = assignVsi2max(event.getPss2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event UnAssignVsi2maxFromPss2BEvent
   */
  @EventHandler(payloadType = UnAssignVsi2maxFromPss2BEvent.class)
  public void handle(UnAssignVsi2maxFromPss2BEvent event) {
    LOGGER.info("handling UnAssignVsi2maxFromPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2B entity = unAssignVsi2max(event.getPss2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event AssignVsi2minToPss2BEvent
   */
  @EventHandler(payloadType = AssignVsi2minToPss2BEvent.class)
  public void handle(AssignVsi2minToPss2BEvent event) {
    LOGGER.info("handling AssignVsi2minToPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2B entity = assignVsi2min(event.getPss2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event UnAssignVsi2minFromPss2BEvent
   */
  @EventHandler(payloadType = UnAssignVsi2minFromPss2BEvent.class)
  public void handle(UnAssignVsi2minFromPss2BEvent event) {
    LOGGER.info("handling UnAssignVsi2minFromPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2B entity = unAssignVsi2min(event.getPss2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event AssignVstmaxToPss2BEvent
   */
  @EventHandler(payloadType = AssignVstmaxToPss2BEvent.class)
  public void handle(AssignVstmaxToPss2BEvent event) {
    LOGGER.info("handling AssignVstmaxToPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2B entity = assignVstmax(event.getPss2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event UnAssignVstmaxFromPss2BEvent
   */
  @EventHandler(payloadType = UnAssignVstmaxFromPss2BEvent.class)
  public void handle(UnAssignVstmaxFromPss2BEvent event) {
    LOGGER.info("handling UnAssignVstmaxFromPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2B entity = unAssignVstmax(event.getPss2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event AssignVstminToPss2BEvent
   */
  @EventHandler(payloadType = AssignVstminToPss2BEvent.class)
  public void handle(AssignVstminToPss2BEvent event) {
    LOGGER.info("handling AssignVstminToPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2B entity = assignVstmin(event.getPss2BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /*
   * @param	event UnAssignVstminFromPss2BEvent
   */
  @EventHandler(payloadType = UnAssignVstminFromPss2BEvent.class)
  public void handle(UnAssignVstminFromPss2BEvent event) {
    LOGGER.info("handling UnAssignVstminFromPss2BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2B entity = unAssignVstmin(event.getPss2BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2B(entity);
  }

  /**
   * Method to retrieve the Pss2B via an Pss2BPrimaryKey.
   *
   * @param id Long
   * @return Pss2B
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public Pss2B handle(FindPss2BQuery query) throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getPss2BId());
  }

  /**
   * Method to retrieve a collection of all Pss2Bs
   *
   * @param query FindAllPss2BQuery
   * @return List<Pss2B>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<Pss2B> handle(FindAllPss2BQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindPss2B, but only if the id matches
   *
   * @param entity Pss2B
   */
  protected void emitFindPss2B(Pss2B entity) {
    LOGGER.info("handling emitFindPss2B");

    queryUpdateEmitter.emit(
        FindPss2BQuery.class,
        query -> query.getFilter().getPss2BId().equals(entity.getPss2BId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllPss2B
   *
   * @param entity Pss2B
   */
  protected void emitFindAllPss2B(Pss2B entity) {
    LOGGER.info("handling emitFindAllPss2B");

    queryUpdateEmitter.emit(FindAllPss2BQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(Pss2BProjector.class.getName());
}
