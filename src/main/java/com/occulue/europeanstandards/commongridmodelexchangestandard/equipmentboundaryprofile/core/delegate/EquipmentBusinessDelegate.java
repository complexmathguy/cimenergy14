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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.core.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.core.validator.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryUpdateEmitter;

/**
 * Equipment business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of Equipment related services in the case of a Equipment business
 *       related service failing.
 *   <li>Exposes a simpler, uniform Equipment interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill Equipment business related
 *       services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class EquipmentBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public EquipmentBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * Equipment Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return EquipmentBusinessDelegate
   */
  public static EquipmentBusinessDelegate getEquipmentInstance() {
    return (new EquipmentBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createEquipment(CreateEquipmentCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getEquipmentId() == null) command.setEquipmentId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      EquipmentValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateEquipmentCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateEquipmentCommand of Equipment is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create Equipment - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateEquipmentCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateEquipment(UpdateEquipmentCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      EquipmentValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateEquipmentCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save Equipment - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteEquipmentCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteEquipmentCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      EquipmentValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteEquipmentCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete Equipment using Id = " + command.getEquipmentId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the Equipment via EquipmentFetchOneSummary
   *
   * @param summary EquipmentFetchOneSummary
   * @return EquipmentFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public Equipment getEquipment(EquipmentFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("EquipmentFetchOneSummary arg cannot be null");

    Equipment entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      EquipmentValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a Equipment
      // --------------------------------------
      CompletableFuture<Equipment> futureEntity =
          queryGateway.query(
              new FindEquipmentQuery(new LoadEquipmentFilter(summary.getEquipmentId())),
              ResponseTypes.instanceOf(Equipment.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate Equipment with id " + summary.getEquipmentId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all Equipments
   *
   * @return List<Equipment>
   * @exception ProcessingException Thrown if any problems
   */
  public List<Equipment> getAllEquipment() throws ProcessingException {
    List<Equipment> list = null;

    try {
      CompletableFuture<List<Equipment>> futureList =
          queryGateway.query(
              new FindAllEquipmentQuery(), ResponseTypes.multipleInstancesOf(Equipment.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all Equipment";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * add Equipment to Equipments
   *
   * @param command AssignEquipmentsToEquipmentCommand
   * @exception ProcessingException
   */
  public void addToEquipments(AssignEquipmentsToEquipmentCommand command)
      throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getEquipmentId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.core
            .delegate.EquipmentBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile
                .core.delegate.EquipmentBusinessDelegate.getEquipmentInstance();
    EquipmentBusinessDelegate parentDelegate = EquipmentBusinessDelegate.getEquipmentInstance();
    UUID childId = command.getAddTo().getEquipmentId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      EquipmentValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to add a Equipment as Equipments to Equipment";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove Equipment from Equipments
   *
   * @param command RemoveEquipmentsFromEquipmentCommand
   * @exception ProcessingException
   */
  public void removeFromEquipments(RemoveEquipmentsFromEquipmentCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.core
            .delegate.EquipmentBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile
                .core.delegate.EquipmentBusinessDelegate.getEquipmentInstance();
    UUID childId = command.getRemoveFrom().getEquipmentId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      EquipmentValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Exception exc) {
      final String msg = "Failed to remove child using Id " + childId;
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return Equipment
   */
  private Equipment load(UUID id) throws ProcessingException {
    equipment =
        EquipmentBusinessDelegate.getEquipmentInstance()
            .getEquipment(new EquipmentFetchOneSummary(id));
    return equipment;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private Equipment equipment = null;
  private static final Logger LOGGER = Logger.getLogger(EquipmentBusinessDelegate.class.getName());
}
