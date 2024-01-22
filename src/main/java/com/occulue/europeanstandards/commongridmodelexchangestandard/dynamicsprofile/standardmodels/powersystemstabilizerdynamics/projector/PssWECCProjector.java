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
 * Projector for PssWECC as outlined for the CQRS pattern. All event handling and query handling
 * related to PssWECC are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by PssWECCAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("pssWECC")
@Component("pssWECC-projector")
public class PssWECCProjector extends PssWECCEntityProjector {

  // core constructor
  public PssWECCProjector(PssWECCRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreatePssWECCEvent
   */
  @EventHandler(payloadType = CreatePssWECCEvent.class)
  public void handle(CreatePssWECCEvent event) {
    LOGGER.info("handling CreatePssWECCEvent - " + event);
    PssWECC entity = new PssWECC();
    entity.setPssWECCId(event.getPssWECCId());
    entity.setInputSignal1Type(event.getInputSignal1Type());
    entity.setInputSignal2Type(event.getInputSignal2Type());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssWECC(entity);
  }

  /*
   * @param	event UpdatePssWECCEvent
   */
  @EventHandler(payloadType = UpdatePssWECCEvent.class)
  public void handle(UpdatePssWECCEvent event) {
    LOGGER.info("handling UpdatePssWECCEvent - " + event);

    PssWECC entity = new PssWECC();
    entity.setPssWECCId(event.getPssWECCId());
    entity.setInputSignal1Type(event.getInputSignal1Type());
    entity.setInputSignal2Type(event.getInputSignal2Type());
    entity.setK1(event.getK1());
    entity.setK2(event.getK2());
    entity.setT1(event.getT1());
    entity.setT10(event.getT10());
    entity.setT2(event.getT2());
    entity.setT3(event.getT3());
    entity.setT4(event.getT4());
    entity.setT5(event.getT5());
    entity.setT6(event.getT6());
    entity.setT7(event.getT7());
    entity.setT8(event.getT8());
    entity.setT9(event.getT9());
    entity.setVcl(event.getVcl());
    entity.setVcu(event.getVcu());
    entity.setVsmax(event.getVsmax());
    entity.setVsmin(event.getVsmin());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssWECC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssWECC(entity);
  }

  /*
   * @param	event DeletePssWECCEvent
   */
  @EventHandler(payloadType = DeletePssWECCEvent.class)
  public void handle(DeletePssWECCEvent event) {
    LOGGER.info("handling DeletePssWECCEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    PssWECC entity = delete(event.getPssWECCId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssWECC(entity);
  }

  /*
   * @param	event AssignK1ToPssWECCEvent
   */
  @EventHandler(payloadType = AssignK1ToPssWECCEvent.class)
  public void handle(AssignK1ToPssWECCEvent event) {
    LOGGER.info("handling AssignK1ToPssWECCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssWECC entity = assignK1(event.getPssWECCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssWECC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssWECC(entity);
  }

  /*
   * @param	event UnAssignK1FromPssWECCEvent
   */
  @EventHandler(payloadType = UnAssignK1FromPssWECCEvent.class)
  public void handle(UnAssignK1FromPssWECCEvent event) {
    LOGGER.info("handling UnAssignK1FromPssWECCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssWECC entity = unAssignK1(event.getPssWECCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssWECC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssWECC(entity);
  }

  /*
   * @param	event AssignK2ToPssWECCEvent
   */
  @EventHandler(payloadType = AssignK2ToPssWECCEvent.class)
  public void handle(AssignK2ToPssWECCEvent event) {
    LOGGER.info("handling AssignK2ToPssWECCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssWECC entity = assignK2(event.getPssWECCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssWECC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssWECC(entity);
  }

  /*
   * @param	event UnAssignK2FromPssWECCEvent
   */
  @EventHandler(payloadType = UnAssignK2FromPssWECCEvent.class)
  public void handle(UnAssignK2FromPssWECCEvent event) {
    LOGGER.info("handling UnAssignK2FromPssWECCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssWECC entity = unAssignK2(event.getPssWECCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssWECC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssWECC(entity);
  }

  /*
   * @param	event AssignT1ToPssWECCEvent
   */
  @EventHandler(payloadType = AssignT1ToPssWECCEvent.class)
  public void handle(AssignT1ToPssWECCEvent event) {
    LOGGER.info("handling AssignT1ToPssWECCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssWECC entity = assignT1(event.getPssWECCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssWECC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssWECC(entity);
  }

  /*
   * @param	event UnAssignT1FromPssWECCEvent
   */
  @EventHandler(payloadType = UnAssignT1FromPssWECCEvent.class)
  public void handle(UnAssignT1FromPssWECCEvent event) {
    LOGGER.info("handling UnAssignT1FromPssWECCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssWECC entity = unAssignT1(event.getPssWECCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssWECC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssWECC(entity);
  }

  /*
   * @param	event AssignT10ToPssWECCEvent
   */
  @EventHandler(payloadType = AssignT10ToPssWECCEvent.class)
  public void handle(AssignT10ToPssWECCEvent event) {
    LOGGER.info("handling AssignT10ToPssWECCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssWECC entity = assignT10(event.getPssWECCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssWECC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssWECC(entity);
  }

  /*
   * @param	event UnAssignT10FromPssWECCEvent
   */
  @EventHandler(payloadType = UnAssignT10FromPssWECCEvent.class)
  public void handle(UnAssignT10FromPssWECCEvent event) {
    LOGGER.info("handling UnAssignT10FromPssWECCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssWECC entity = unAssignT10(event.getPssWECCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssWECC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssWECC(entity);
  }

  /*
   * @param	event AssignT2ToPssWECCEvent
   */
  @EventHandler(payloadType = AssignT2ToPssWECCEvent.class)
  public void handle(AssignT2ToPssWECCEvent event) {
    LOGGER.info("handling AssignT2ToPssWECCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssWECC entity = assignT2(event.getPssWECCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssWECC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssWECC(entity);
  }

  /*
   * @param	event UnAssignT2FromPssWECCEvent
   */
  @EventHandler(payloadType = UnAssignT2FromPssWECCEvent.class)
  public void handle(UnAssignT2FromPssWECCEvent event) {
    LOGGER.info("handling UnAssignT2FromPssWECCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssWECC entity = unAssignT2(event.getPssWECCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssWECC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssWECC(entity);
  }

  /*
   * @param	event AssignT3ToPssWECCEvent
   */
  @EventHandler(payloadType = AssignT3ToPssWECCEvent.class)
  public void handle(AssignT3ToPssWECCEvent event) {
    LOGGER.info("handling AssignT3ToPssWECCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssWECC entity = assignT3(event.getPssWECCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssWECC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssWECC(entity);
  }

  /*
   * @param	event UnAssignT3FromPssWECCEvent
   */
  @EventHandler(payloadType = UnAssignT3FromPssWECCEvent.class)
  public void handle(UnAssignT3FromPssWECCEvent event) {
    LOGGER.info("handling UnAssignT3FromPssWECCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssWECC entity = unAssignT3(event.getPssWECCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssWECC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssWECC(entity);
  }

  /*
   * @param	event AssignT4ToPssWECCEvent
   */
  @EventHandler(payloadType = AssignT4ToPssWECCEvent.class)
  public void handle(AssignT4ToPssWECCEvent event) {
    LOGGER.info("handling AssignT4ToPssWECCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssWECC entity = assignT4(event.getPssWECCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssWECC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssWECC(entity);
  }

  /*
   * @param	event UnAssignT4FromPssWECCEvent
   */
  @EventHandler(payloadType = UnAssignT4FromPssWECCEvent.class)
  public void handle(UnAssignT4FromPssWECCEvent event) {
    LOGGER.info("handling UnAssignT4FromPssWECCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssWECC entity = unAssignT4(event.getPssWECCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssWECC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssWECC(entity);
  }

  /*
   * @param	event AssignT5ToPssWECCEvent
   */
  @EventHandler(payloadType = AssignT5ToPssWECCEvent.class)
  public void handle(AssignT5ToPssWECCEvent event) {
    LOGGER.info("handling AssignT5ToPssWECCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssWECC entity = assignT5(event.getPssWECCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssWECC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssWECC(entity);
  }

  /*
   * @param	event UnAssignT5FromPssWECCEvent
   */
  @EventHandler(payloadType = UnAssignT5FromPssWECCEvent.class)
  public void handle(UnAssignT5FromPssWECCEvent event) {
    LOGGER.info("handling UnAssignT5FromPssWECCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssWECC entity = unAssignT5(event.getPssWECCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssWECC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssWECC(entity);
  }

  /*
   * @param	event AssignT6ToPssWECCEvent
   */
  @EventHandler(payloadType = AssignT6ToPssWECCEvent.class)
  public void handle(AssignT6ToPssWECCEvent event) {
    LOGGER.info("handling AssignT6ToPssWECCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssWECC entity = assignT6(event.getPssWECCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssWECC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssWECC(entity);
  }

  /*
   * @param	event UnAssignT6FromPssWECCEvent
   */
  @EventHandler(payloadType = UnAssignT6FromPssWECCEvent.class)
  public void handle(UnAssignT6FromPssWECCEvent event) {
    LOGGER.info("handling UnAssignT6FromPssWECCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssWECC entity = unAssignT6(event.getPssWECCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssWECC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssWECC(entity);
  }

  /*
   * @param	event AssignT7ToPssWECCEvent
   */
  @EventHandler(payloadType = AssignT7ToPssWECCEvent.class)
  public void handle(AssignT7ToPssWECCEvent event) {
    LOGGER.info("handling AssignT7ToPssWECCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssWECC entity = assignT7(event.getPssWECCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssWECC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssWECC(entity);
  }

  /*
   * @param	event UnAssignT7FromPssWECCEvent
   */
  @EventHandler(payloadType = UnAssignT7FromPssWECCEvent.class)
  public void handle(UnAssignT7FromPssWECCEvent event) {
    LOGGER.info("handling UnAssignT7FromPssWECCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssWECC entity = unAssignT7(event.getPssWECCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssWECC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssWECC(entity);
  }

  /*
   * @param	event AssignT8ToPssWECCEvent
   */
  @EventHandler(payloadType = AssignT8ToPssWECCEvent.class)
  public void handle(AssignT8ToPssWECCEvent event) {
    LOGGER.info("handling AssignT8ToPssWECCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssWECC entity = assignT8(event.getPssWECCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssWECC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssWECC(entity);
  }

  /*
   * @param	event UnAssignT8FromPssWECCEvent
   */
  @EventHandler(payloadType = UnAssignT8FromPssWECCEvent.class)
  public void handle(UnAssignT8FromPssWECCEvent event) {
    LOGGER.info("handling UnAssignT8FromPssWECCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssWECC entity = unAssignT8(event.getPssWECCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssWECC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssWECC(entity);
  }

  /*
   * @param	event AssignT9ToPssWECCEvent
   */
  @EventHandler(payloadType = AssignT9ToPssWECCEvent.class)
  public void handle(AssignT9ToPssWECCEvent event) {
    LOGGER.info("handling AssignT9ToPssWECCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssWECC entity = assignT9(event.getPssWECCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssWECC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssWECC(entity);
  }

  /*
   * @param	event UnAssignT9FromPssWECCEvent
   */
  @EventHandler(payloadType = UnAssignT9FromPssWECCEvent.class)
  public void handle(UnAssignT9FromPssWECCEvent event) {
    LOGGER.info("handling UnAssignT9FromPssWECCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssWECC entity = unAssignT9(event.getPssWECCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssWECC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssWECC(entity);
  }

  /*
   * @param	event AssignVclToPssWECCEvent
   */
  @EventHandler(payloadType = AssignVclToPssWECCEvent.class)
  public void handle(AssignVclToPssWECCEvent event) {
    LOGGER.info("handling AssignVclToPssWECCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssWECC entity = assignVcl(event.getPssWECCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssWECC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssWECC(entity);
  }

  /*
   * @param	event UnAssignVclFromPssWECCEvent
   */
  @EventHandler(payloadType = UnAssignVclFromPssWECCEvent.class)
  public void handle(UnAssignVclFromPssWECCEvent event) {
    LOGGER.info("handling UnAssignVclFromPssWECCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssWECC entity = unAssignVcl(event.getPssWECCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssWECC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssWECC(entity);
  }

  /*
   * @param	event AssignVcuToPssWECCEvent
   */
  @EventHandler(payloadType = AssignVcuToPssWECCEvent.class)
  public void handle(AssignVcuToPssWECCEvent event) {
    LOGGER.info("handling AssignVcuToPssWECCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssWECC entity = assignVcu(event.getPssWECCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssWECC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssWECC(entity);
  }

  /*
   * @param	event UnAssignVcuFromPssWECCEvent
   */
  @EventHandler(payloadType = UnAssignVcuFromPssWECCEvent.class)
  public void handle(UnAssignVcuFromPssWECCEvent event) {
    LOGGER.info("handling UnAssignVcuFromPssWECCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssWECC entity = unAssignVcu(event.getPssWECCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssWECC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssWECC(entity);
  }

  /*
   * @param	event AssignVsmaxToPssWECCEvent
   */
  @EventHandler(payloadType = AssignVsmaxToPssWECCEvent.class)
  public void handle(AssignVsmaxToPssWECCEvent event) {
    LOGGER.info("handling AssignVsmaxToPssWECCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssWECC entity = assignVsmax(event.getPssWECCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssWECC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssWECC(entity);
  }

  /*
   * @param	event UnAssignVsmaxFromPssWECCEvent
   */
  @EventHandler(payloadType = UnAssignVsmaxFromPssWECCEvent.class)
  public void handle(UnAssignVsmaxFromPssWECCEvent event) {
    LOGGER.info("handling UnAssignVsmaxFromPssWECCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssWECC entity = unAssignVsmax(event.getPssWECCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssWECC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssWECC(entity);
  }

  /*
   * @param	event AssignVsminToPssWECCEvent
   */
  @EventHandler(payloadType = AssignVsminToPssWECCEvent.class)
  public void handle(AssignVsminToPssWECCEvent event) {
    LOGGER.info("handling AssignVsminToPssWECCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssWECC entity = assignVsmin(event.getPssWECCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssWECC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssWECC(entity);
  }

  /*
   * @param	event UnAssignVsminFromPssWECCEvent
   */
  @EventHandler(payloadType = UnAssignVsminFromPssWECCEvent.class)
  public void handle(UnAssignVsminFromPssWECCEvent event) {
    LOGGER.info("handling UnAssignVsminFromPssWECCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssWECC entity = unAssignVsmin(event.getPssWECCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssWECC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssWECC(entity);
  }

  /**
   * Method to retrieve the PssWECC via an PssWECCPrimaryKey.
   *
   * @param id Long
   * @return PssWECC
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public PssWECC handle(FindPssWECCQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getPssWECCId());
  }

  /**
   * Method to retrieve a collection of all PssWECCs
   *
   * @param query FindAllPssWECCQuery
   * @return List<PssWECC>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<PssWECC> handle(FindAllPssWECCQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindPssWECC, but only if the id matches
   *
   * @param entity PssWECC
   */
  protected void emitFindPssWECC(PssWECC entity) {
    LOGGER.info("handling emitFindPssWECC");

    queryUpdateEmitter.emit(
        FindPssWECCQuery.class,
        query -> query.getFilter().getPssWECCId().equals(entity.getPssWECCId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllPssWECC
   *
   * @param entity PssWECC
   */
  protected void emitFindAllPssWECC(PssWECC entity) {
    LOGGER.info("handling emitFindAllPssWECC");

    queryUpdateEmitter.emit(FindAllPssWECCQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(PssWECCProjector.class.getName());
}
