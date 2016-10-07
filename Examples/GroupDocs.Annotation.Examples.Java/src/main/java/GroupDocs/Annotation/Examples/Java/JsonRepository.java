package GroupDocs.Annotation.Examples.Java;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.groupdocs.annotation.handler.input.IRepository;
import com.groupdocs.annotation.handler.input.dataobjects.IEntity;

public abstract class JsonRepository<TEntity extends IEntity> extends JsonFile<List<TEntity>>
		implements IRepository<TEntity> {
	private final String _entityName = getClazz().getClass().getName();

	public JsonRepository(String filePath) throws Exception {
		super(filePath);
	}

	public void commit() {
		try {
			serialize();
		} catch (Exception e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, String.format("Unable to commit changes: %s", _entityName),
					e);
		}
	}

	public void refresh(TEntity entity) {
		try {
			deserialize();
		} catch (Exception e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, String.format("Unable to refresh changes: %s", _entityName),
					e);
		}
	}

	public boolean add(TEntity entity) {
		synchronized (_syncRoot) {
			try {
				List<TEntity> data = this.getData();
				entity.setId(GetNextId(1));
				data.add(entity);
				commit();
				return true;
			} catch (Exception e) {
				Logger.getAnonymousLogger().log(Level.SEVERE, String.format("Unable to add entity: %s", _entityName),
						e);
			}
		}
		return true;
	}

	public boolean remove(TEntity entity) {
		synchronized (_syncRoot) {
			try {
				for (TEntity e : getData()) {
					if (e.getId() == entity.getId()) {
						getData().remove(e);
					}
				}
				commit();
				return true;
			} catch (Exception e) {
				Logger.getAnonymousLogger().log(Level.SEVERE, String.format("Unable to remove entity: %s", _entityName),
						e);
			}
		}
		return false;
	}

	public boolean update(TEntity entity) {
		synchronized (_syncRoot) {
			try {
				List<TEntity> data = this.getData();
				int index = -1;
				for (int n = 0; n < data.size(); n++) {
					TEntity x = data.get(n);
					if (x.getId() == entity.getId()) {
						index = n;
						break;
					}
				}
				if (index >= 0) {
					data.set(index, entity);
					commit();
					return true;
				}
				return false;
			} catch (Exception e) {
				Logger.getAnonymousLogger().log(Level.SEVERE, String.format("Unable to update entity: %s", _entityName),
						e);
			}
		}
		return true;
	}

	public boolean add(List<TEntity> entities) {
		synchronized (_syncRoot) {
			try {
				getData().addAll(entities);
				commit();
				return true;
			} catch (Exception e) {
				Logger.getAnonymousLogger().log(Level.SEVERE, String.format("Unable to add entities: %s", _entityName),
						e);
			}
		}
		return true;
	}

	public boolean remove(List<TEntity> entities) {
		synchronized (_syncRoot) {
			try {
				List<TEntity> data = this.getData();
				for (IEntity e : entities) {
					data.remove(e);
				}
				commit();
				return true;
			} catch (Exception e) {
				Logger.getAnonymousLogger().log(Level.SEVERE,
						String.format("Unable to remove entities: %s", _entityName), e);
			}
		}
		return true;
	}

	public boolean update(List<TEntity> entities) {
		synchronized (_syncRoot) {
			try {
				List<TEntity> data = this.getData();
				for (TEntity e : entities) {
					int index = -1;
					for (int n = 0; n < data.size(); n++) {
						TEntity x = data.get(n);
						if (x.getId() == e.getId()) {
							index = n;
							break;
						}
					}
					if (index >= 0) {
						data.set(index, e);
					}
				}
				commit();
				return true;
			} catch (Exception e) {
				Logger.getAnonymousLogger().log(Level.SEVERE,
						String.format("Unable to update entities: %s", _entityName), e);
			}
		}
		return true;
	}

	public TEntity get(double id) {
		synchronized (_syncRoot) {
			try {
				for (TEntity e : getData()) {
					if (e.getId() == e.getId()) {
						return e;
					}
				}
			} catch (Exception e) {
				Logger.getAnonymousLogger().log(Level.SEVERE, String.format("Unable to get entity: ID = %s", id), e);
			}
		}
		return null;
	}

	public TEntity get(long id) {
		return get((double) id);
	}

	protected long GetNextId(int increment) throws Exception {
		List<TEntity> data = getData();
		long lastId = 0L;
		if (!data.isEmpty()) {
			Collections.sort(data, new Comparator<TEntity>() {
				public int compare(TEntity o1, TEntity o2) {
					return (int) (o1.getId() - o2.getId());
				}
			});
			lastId = data.get(data.size() - 1).getId();
		}
		return (lastId + increment);
	}
}
